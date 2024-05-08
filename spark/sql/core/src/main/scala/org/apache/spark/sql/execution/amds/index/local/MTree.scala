/*
 *  Copyright 2023 by DIMS Project
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.apache.spark.sql.execution.amds.index.local

import org.apache.spark.sql.catalyst.expressions.amds.common.shape.Point

import scala.collection.mutable.{ArrayBuffer, PriorityQueue}
import scala.util.control.Breaks.{break, breakable}

case class MTree[A](var root: Node[A] = new Leaf[A](Vector.empty, null),
                    var InnerOrder: Int, var LeafOrder: Int) {
  def insert(entry: Entry[A]): Unit = {
    insertRecursion(entry) match {
      case Left(ro) => root = new Branch[A](ro, null);
      case Right(_) =>
    };

    def insertRecursion(entry: Entry[A], curr: Node[A] = root):
    Either[Vector[RoutingObject[A]], Double] = {
      curr match {
        case current: Leaf[A] =>

          if (current != root) entry.DistanceFromParent = current.center.minDist(entry.center);
          assert(entry.DistanceFromParent != -1);
          current.children = current.children :+ entry;
          if (current.children.length > LeafOrder) {
            return Left(current.split(LeafOrder / 2))
          };
          else {
            return Right(entry.DistanceFromParent)
          };

        case current: Branch[A] =>

          var MinIndex = -1;
          var MinExpansionIndex = -1;
          var MinDistance = Double.PositiveInfinity;
          var MinExpansionDistance = Double.PositiveInfinity;
          for (i <- 0 to current.children.length - 1) {
            val CurrentDistance = current.children(i).center.minDist(entry.center);
            val CurrentExpansionDistance = CurrentDistance - current.children(i).radius;
            if (CurrentDistance <= current.children(i).radius) {
              if (CurrentDistance < MinDistance) {
                MinDistance = CurrentDistance;
                MinIndex = i;
              }
            } else if (CurrentExpansionDistance < MinExpansionDistance) {
              MinExpansionDistance = CurrentExpansionDistance;
              MinExpansionIndex = i;
            }
          }
          if (MinIndex == -1) MinIndex = MinExpansionIndex;


          insertRecursion(entry, current.children(MinIndex).CoveringTree) match {
            case Left(ro) =>
              if (current != root) {
                ro.foreach(e => e.DistanceFromParent = e.center.minDist(current.center));
              }
              current.children = current.children.take(MinIndex) ++
                current.children.drop(MinIndex + 1) ++ ro;
              var newRadius = -1.0;
              if (current != root) {
                for (c <- current.children) {
                  if (current.center.minDist(c.center) + c.radius > newRadius) {
                    newRadius = current.center.minDist(c.center) + c.radius
                  };
                }
              }
              if (current.children.length > InnerOrder) {
                return Left(current.split(InnerOrder / 2))
              };
              else {
                return Right(newRadius)
              };

            case Right(value) =>
              current.children(MinIndex).radius =
                Math.max(value, current.children(MinIndex).radius);

              return Right(current.children(MinIndex).radius
                + current.children(MinIndex).DistanceFromParent);
          };
      }
    }
  }

  def getQueryDistanceFromParent(entry: Entry[A]): Double = {
    def insertRecursion(entry: Entry[A], curr: Node[A] = root):
    Either[Vector[RoutingObject[A]], Double] = {
      curr match {
        case current: Leaf[A] =>
          if (current != root) entry.DistanceFromParent = current.center.minDist(entry.center);
          assert(entry.DistanceFromParent != -1);
          return Right(entry.DistanceFromParent);

        case current: Branch[A] =>
          var MinIndex = -1;
          var MinExpansionIndex = -1;
          var MinDistance = Double.PositiveInfinity;
          var MinExpansionDistance = Double.PositiveInfinity;
          for (i <- 0 to current.children.length - 1) {
            val CurrentDistance = current.children(i).center.minDist(entry.center);
            val CurrentExpansionDistance = CurrentDistance - current.children(i).radius;
            if (CurrentDistance <= current.children(i).radius) {
              if (CurrentDistance < MinDistance) {
                MinDistance = CurrentDistance;
                MinIndex = i;
              }
            } else if (CurrentExpansionDistance < MinExpansionDistance) {
              MinExpansionDistance = CurrentExpansionDistance;
              MinExpansionIndex = i;
            }
          }
          if (MinIndex == -1) MinIndex = MinExpansionIndex;
          insertRecursion(entry, current.children(MinIndex).CoveringTree) match {
            case Left(ro) =>
              Right(-1);
            case Right(value) =>
              return Right(value);
          };
      }
    }

    insertRecursion(entry) match {
      case Left(ro) => return -1;
      case Right(value) => return value
    };

  }

  def remove(entry: Entry[A]): Boolean = {
    removeRecursion(entry) match {
      case Left(q) =>
        for (k <- q._1) {
          if (k.isInstanceOf[Leaf[A]]) {
            for (c <- k.asInstanceOf[Leaf[A]].children) {
              this.insert(c);
            }
          } else {
            insertInternal(k);
          }
        }
        return true;
      case Right(k) =>
        if (k != -1) {
          return true
        };
        else {
          return false
        };
    }

    def removeRecursion(entry: Entry[A], radius: Double = -1, curr: Node[A] = root):
    Either[(ArrayBuffer[Node[A]], Double, Boolean), Double] = {
      if (curr.isInstanceOf[Leaf[A]]) {
        val current = curr.asInstanceOf[Leaf[A]];
        var SearchEntry = -1;
        breakable {
          var i = 0;
          for (k <- current.children) {
            if (k.center == entry.center
            /* && k.value == entry.value */ ) {
              SearchEntry = i;
              break;
            }
            i = i + 1;
          }
        }

        if (SearchEntry == -1) return Right(-1);

        var deletedDist = current.children(SearchEntry).DistanceFromParent;
        current.children = current.children.take(SearchEntry) ++
          current.children.drop(SearchEntry + 1);

        var newRadius = Double.NegativeInfinity;
        if (deletedDist == radius) {
          for (k <- current.children) {
            if (k.DistanceFromParent > radius) newRadius = k.DistanceFromParent;
          }
        }

        if (current.children.length < 2) return Left((ArrayBuffer(current), newRadius, true));
        return Right(newRadius);
      } else {
        val current = curr.asInstanceOf[Branch[A]];
        var i = 0;
        for (c <- current.children) {

          if (c.center.minDist(entry.center) <= c.radius) {
            removeRecursion(entry, c.radius, c.CoveringTree) match {
              case Left(q) =>
                if (!q._2.isNegInfinity) c.radius = q._2;

                if (q._3) {
                  current.children = current.children.take(i) ++ current.children.drop(i + 1)
                };

                var newRadius = Double.NegativeInfinity;
                if (q._3 || !q._2.isNegInfinity) {
                  for (k <- current.children) {
                    if (k.DistanceFromParent + k.radius > radius) {
                      newRadius = k.DistanceFromParent + k.radius
                    };
                  }
                }

                if (current.children.length < 2) {
                  q._1.append(current);
                  return Left((q._1, newRadius, true));
                }

                return Left((q._1, newRadius, false));

              case Right(-1) =>

              case Right(r) =>
                var newRadius = Double.NegativeInfinity;
                if (!r.isNegInfinity) {
                  c.radius = r;

                  for (k <- current.children) {
                    if (k.DistanceFromParent + k.radius > newRadius) {
                      newRadius = k.DistanceFromParent + k.radius
                    };
                  }
                }

                return Right(newRadius);
            }
          }
          i = i + 1;
        }
        return Right(-1);
      }
    }

    def insertInternal(n: Node[A]): Unit = {
      if (n.isInstanceOf[Leaf[A]]) {
        for (k <- n.asInstanceOf[Leaf[A]].children) {
          this.insert(k);
        }
      } else {
        n.asInstanceOf[Branch[A]].children.foreach(c => insertInternal(c.CoveringTree))
      }
    }

    return true;
  }

  def update(OldEntry: Entry[A], NewEntry: Entry[A]): Boolean = {
    def updateRecursion(OldEntry: Entry[A], NewEntryValue: A, curr: Node[A] = root): Boolean = {
      if (curr.isInstanceOf[Leaf[A]]) {
        val current = curr.asInstanceOf[Leaf[A]];
        for (c <- current.children) {
          if (c.center == OldEntry.center) {
            c.value = NewEntryValue;
            return true;
          }
        }
        return false;
      } else {
        val current = curr.asInstanceOf[Branch[A]];
        var result = -1;
        for (c <- current.children) {
          if (c.center.minDist(OldEntry.center) <= c.radius) {
            if (updateRecursion(OldEntry, NewEntryValue, c.CoveringTree)) return true;
          }
        }
        return false;
      }
    }

    if (OldEntry.center != NewEntry.center) {
      if (remove(OldEntry)) {
        insert(NewEntry);
        return true;
      }
      return false;
    } else {
      if (updateRecursion(OldEntry, NewEntry.value)) return true;
      return false;
    }
  }

  def RangeSearch(SearchPoint: Point[Any], SearchRadius: Double): Vector[Entry[A]] = {
    def RangeSearchRecursion(SearchPoint: Point[Any], SearchRadius: Double,
                             curr: Node[A] = root, DistanceQP: Double = 0): Vector[Entry[A]] = {
      if (curr == root) {
        if (curr.isInstanceOf[Leaf[A]]) {
          val current = curr.asInstanceOf[Leaf[A]];
          var found = Vector[Entry[A]]();
          for (e <- current.children) {
            if (SearchPoint.minDist(e.center) <= SearchRadius) {
              found = found :+ e;
            }
          }
          return found;
        } else {
          val current = curr.asInstanceOf[Branch[A]];
          var found = Vector[Entry[A]]();
          for (or <- current.children) {
            val distanceQP = SearchPoint.minDist(or.center);
            if (distanceQP <= SearchRadius + or.radius) {
              found =
                found ++ RangeSearchRecursion(SearchPoint,
                  SearchRadius, or.CoveringTree, distanceQP)
            };
          }
          return found;
        }
      } else {
        if (curr.isInstanceOf[Leaf[A]]) {
          val current = curr.asInstanceOf[Leaf[A]];
          var found = Vector[Entry[A]]();
          for (e <- current.children) {
            if (Math.abs(DistanceQP - e.DistanceFromParent) <= SearchRadius) {
              if (SearchPoint.minDist(e.center) <= SearchRadius) {
                found = found :+ e;
              }
            }
          }
          return found;
        } else {
          val current = curr.asInstanceOf[Branch[A]];
          var found = Vector[Entry[A]]();
          for (or <- current.children) {
            if (Math.abs(DistanceQP - or.DistanceFromParent) <= SearchRadius + or.radius) {
              val distanceQP = SearchPoint.minDist(or.center);
              if (distanceQP <= SearchRadius + or.radius) {
                found = found ++
                  RangeSearchRecursion(SearchPoint, SearchRadius, or.CoveringTree, distanceQP)
              };
            }
          }
          return found;
        }
      }
    }

    return RangeSearchRecursion(SearchPoint, SearchRadius);
  }

  def indexRangeSearch(SearchPoint: Point[Any], SearchRadius: Double): Vector[Int] = {
    def RangeSearchRecursion(SearchPoint: Point[Any], SearchRadius: Double,
                             curr: Node[A] = root, DistanceQP: Double = 0): Vector[Int] = {
      if (curr == root) {
        if (curr.isInstanceOf[Leaf[A]]) {
          val current = curr.asInstanceOf[Leaf[A]];
          var found = Vector[Int]();
          found = found :+ current.getNum();
          found;
        } else {
          val current = curr.asInstanceOf[Branch[A]];
          var found = Vector[Int]();
          for (or <- current.children) {
            val distanceQP = SearchPoint.minDist(or.center);
            if (distanceQP <= SearchRadius + or.radius) {
              found =
                found ++ RangeSearchRecursion(SearchPoint,
                  SearchRadius, or.CoveringTree, distanceQP)
            };
          }
          return found;
        }
      } else {
        if (curr.isInstanceOf[Leaf[A]]) {
          val current = curr.asInstanceOf[Leaf[A]];
          var found = Vector[Int]();
          found = found :+ current.getNum();
          return found;
        } else {
          val current = curr.asInstanceOf[Branch[A]];
          var found = Vector[Int]();
          for (or <- current.children) {
            if (Math.abs(DistanceQP - or.DistanceFromParent) <= SearchRadius + or.radius) {
              val distanceQP = SearchPoint.minDist(or.center);
              if (distanceQP <= SearchRadius + or.radius) {
                found = found ++
                  RangeSearchRecursion(SearchPoint, SearchRadius, or.CoveringTree, distanceQP)
              };
            }
          }
          return found;
        }
      }
    }

    return RangeSearchRecursion(SearchPoint, SearchRadius);
  }

  def kNNSearch(Q: Point[Any], k: Int): Array[(Entry[A], Double)] = {
    def NNUpdate(oj: Entry[A], dist: Double, arr: Array[(Entry[A], Double)]):
    (Array[(Entry[A], Double)], Double) = {
      var NN = arr.sortWith(_._2 < _._2);
      var newDk = 0.0;
      if (k > 1) {
        if (dist > NN(NN.length - 2)._2) {
          newDk = dist
        };
        else {
          newDk = NN(NN.length - 2)._2
        };
      } else {
        if (dist > NN(NN.length - 1)._2) {
          newDk = dist
        };
        else {
          newDk = NN(NN.length - 1)._2
        };
      }

      NN = NN.dropRight(1) :+ (oj, dist);
      return (NN, newDk);
    }

    var PR = new PriorityQueue[(Node[A], Double)]()(Ordering.by((_: (Node[A], Double))._2).reverse);
    PR.enqueue((root, 0));
    var NN: Array[(Entry[A], Double)] = Array.fill(k)((null, Double.PositiveInfinity));
    var dk = Double.PositiveInfinity;
    breakable {
      while (!PR.isEmpty) {
        var Current = PR.dequeue();
        if (Current._2 > dk) break;
        var NextNode = Current._1;
        if (NextNode.isInstanceOf[Leaf[A]]) {
          val current = NextNode.asInstanceOf[Leaf[A]];
          for (oj <- current.children) {
            val dist = oj.center.minDist(Q);
            if (dist <= dk) {
              val (newNN, newDk) = NNUpdate(oj, dist, NN);
              NN = newNN;
              dk = newDk;
            }
          }
        } else {
          val current = NextNode.asInstanceOf[Branch[A]];
          for (or <- current.children) {
            val dist = or.center.minDist(Q);
            if (dist <= dk + or.radius) {
              var dmin: Double = 0;
              if (dist - or.radius > 0) dmin = dist - or.radius;
              if (dmin <= dk) {
                PR.enqueue((or.CoveringTree, dmin));
                val dmax = dist + or.radius;
                if (dmax < dk) {
                  val (newNN, newDk) = NNUpdate(null, dmax, NN);
                  NN = newNN;
                  dk = newDk;
                }
              }
            }
          }
        }
      }
    }

    return NN.sortWith(_._2 < _._2);
  }

  def calChildrenNum(curr: Node[A]): Unit = {
    if (curr.isInstanceOf[Leaf[A]]) {
      val current = curr.asInstanceOf[Leaf[A]];
      current.childrenNum = current.children.length;
    } else {
      val current = curr.asInstanceOf[Branch[A]];
      current.children.foreach(x => calChildrenNum(x.CoveringTree))
      current.childrenNum = current.children.map(x =>
        x.CoveringTree.childrenNum).sum
    }
  }

  def estimatedKNNDist(Q: Point[Any], k: Int): Double = {

    var PR = new PriorityQueue[(Node[A], Double)]()(Ordering.by((_: (Node[A], Double))._2).reverse);
    PR.enqueue((root, 0));
    //    var NN: Array[(Entry[A], Double)] = Array.fill(k)((null, Double.PositiveInfinity));
    var dk = Double.PositiveInfinity;
    breakable {
      while (!PR.isEmpty) {
        var Current = PR.dequeue();
        if (Current._2 > dk) break;
        var NextNode = Current._1;

        if (NextNode.isInstanceOf[Leaf[A]]) {
          val current = NextNode.asInstanceOf[Leaf[A]];
          val dist = current.children.map(x => x.center.minDist(Q)).sorted
          dk = dist.last
          break
        } else {
          if (k < NextNode.childrenNum && NextNode.childrenNum < 1.5 * k) {
            val current = NextNode.asInstanceOf[Branch[A]];
            val dist = current.children.map(x => x.center.minDist(Q) + x.radius).sorted
            dk = dist.last
            break
          } else {
            val current = NextNode.asInstanceOf[Branch[A]];
            for (or <- current.children) {
              val dist = or.center.minDist(Q);
              if (dist <= dk + or.radius) {
                var dmin: Double = 0;
                if (dist - or.radius > 0) dmin = dist - or.radius;
                if (dmin <= dk) {
                  PR.enqueue((or.CoveringTree, dmin));
                  val dmax = dist + or.radius;
                  if (dmax < dk) {
                    dk = dmax;
                  }
                }
              }
            }
          }
        }
      }
    }
    dk
  }

  def traverse(radius: Double = -1, curr: Node[A] = root): Double = {
    if (curr.isInstanceOf[Leaf[A]]) {
      val current = curr.asInstanceOf[Leaf[A]];
      var newRadius = Double.NegativeInfinity;
      var counter = 0;
      var children = 0;
      if (current.children.length < 2) children = children + 1;
      var flag = false;
      //         for (i <- 0 to current.children.length - 1) {
      //                      if ( current != root ) {
      //                          if (radius < current.children(i).DistanceFromParent) {
      //                              flag = true;
      //                              counter = counter + 1;
      //                          }
      //                      }
      //                     if (current.children(i).value == "Nani Clows") {
      //                          println("To vrika");
      //                          return 1;
      //                      }
      //                    // if ( current.children(i).DistanceFromParent == -1 )
      //                    println(current.children(i).DistanceFromParent);
      //                  }
      if (current != root) {
        for (k <- current.children) {
          val CurrentDistance = k.center.minDist(current.center);
          if (CurrentDistance > newRadius) newRadius = CurrentDistance;
        }
      }
      return newRadius;
    }
    else {
      val current = curr.asInstanceOf[Branch[A]];
      var counter = 0;
      var children = 0;
      if (current.children.length == 1) children = children + 1;
      // if (current.center != null && current.center.x == -4.6484733
      // && current.center.y == 60.107338)
      // println("To vrika opou nanai")
      // if (current.children.length == 0)
      // println("EXEIS MHDEN PAIDIA");
      var flag = false;
      for (i <- 0 to current.children.length - 1) {

        var newRadius = traverse(current.children(i).radius,
          current.children(i).CoveringTree);
        if (newRadius != Double.NegativeInfinity) current.children(i).radius = newRadius;
        // println("Child: " + i)
      }

      if (current != root) {
        var newRadius = Double.NegativeInfinity;
        for (k <- current.children) {
          val CurrentDistance = k.center.minDist(current.center) + k.radius;
          if (CurrentDistance > newRadius) newRadius = CurrentDistance;
        }
        return newRadius
      }
      return -1;
    }

  }

  def counter(radius: Double, curr: Node[A] = root): Int = {
    if (curr.isInstanceOf[Leaf[A]]) {
      val current = curr.asInstanceOf[Leaf[A]];
      var newRadius = Double.NegativeInfinity;
      var c = 0;
      var children = 0;
      if (current.children.length < 2) children = children + 1;
      var flag = false;
      for (i <- 0 to current.children.length - 1) {
        if (current != root) {
          if (radius < current.children(i).center.minDist(current.center)) {
            c = c + 1;
          }
        }
      }
      return c;
    }
    else {
      val current = curr.asInstanceOf[Branch[A]];
      var c = 0;
      var children = 0;
      if (current.children.length == 1) children = children + 1;
      var flag = false;
      for (i <- 0 to current.children.length - 1) {
        if (current != root && current.center.minDist(current.children(i).center)
          + current.children(i).radius > radius) {
          c = c + 1
        }
        c = c + counter(current.children(i).radius, current.children(i).CoveringTree);

      }
      return c;
    }
  }

  def find(pt: Entry[A], curr: Node[A] = root): Boolean = {
    if (curr.isInstanceOf[Leaf[A]]) {
      for (k <- curr.asInstanceOf[Leaf[A]].children) {
        if (k.center == pt.center && k.value == pt.value) {
          // println("To vrika")
          return true;
        }
      }
      return false;
    } else {
      var flag = false;
      var i = 0
      // println("Level")
      for (k <- curr.asInstanceOf[Branch[A]].children) {
        if (k.center.minDist(pt.center) <= k.radius) {
          // println("Child: " + i);
          if (find(pt, k.CoveringTree)) return true;
        }
        i = i + 1;
      }
      return false;
    }
  }

  def setLeafIndex(curr: Node[A] = root, num: Int): Int = {
    curr match {
      case current: Leaf[A] =>
        current.setLeafIndex(num)
        num + 1
      case current: Branch[A] =>
        var i = num
        for (k <- current.children) {
          i = setLeafIndex(k.CoveringTree, i)
        }
        i
    }
  }


  def getLeafIndex(pt: Entry[A], curr: Node[A] = root): Int = {
    if (curr.isInstanceOf[Leaf[A]]) {
      for (k <- curr.asInstanceOf[Leaf[A]].children) {
        if (k.center == pt.center && k.value == pt.value) {
          return curr.asInstanceOf[Leaf[A]].getNum()
        }
      }
      return -1;
    } else {
      var flag = false;
      var i = 0
      for (k <- curr.asInstanceOf[Branch[A]].children) {
        if (k.center.minDist(pt.center) <= k.radius) {
          val res = getLeafIndex(pt, k.CoveringTree)
          if (res != (-1)) return res
        }
        i = i + 1;
      }
      return -1;
    }
  }

  def calNumPartition(curr: Node[A] = root): Int = {
    if (curr.isInstanceOf[Leaf[A]]) {
      curr.asInstanceOf[Leaf[A]].getNum()
    }
    else {
      calNumPartition(curr.asInstanceOf[Branch[A]].children.last.CoveringTree)
    }
  }

  def getDistanceFromParent(pt: Entry[A], curr: Node[A] = root): Double = {
    if (curr.isInstanceOf[Leaf[A]]) {
      for (k <- curr.asInstanceOf[Leaf[A]].children) {
        if (k.center == pt.center && k.value == pt.value) {
          return k.DistanceFromParent
        }
      }
      return -1;
    } else {
      var i = 0
      for (k <- curr.asInstanceOf[Branch[A]].children) {
        if (k.center.minDist(pt.center) <= k.radius) {
          val res = getDistanceFromParent(pt, k.CoveringTree)
          if (res != (-1)) return res
        }
        i = i + 1;
      }
      return -1;
    }
  }
}