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

import org.apache.spark.sql.catalyst.expressions.amds.common.shape.{Point, Shape}

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.{break, breakable}

// TODO: extends Serializable?
sealed abstract class Node[A](var childrenNum: Int = -1) extends Serializable {
  def center: Point[Any]
}

case class Branch[A](var children: Vector[RoutingObject[A]],
                     var center: Point[Any]) extends Node[A] {
  def split(m: Int): Vector[RoutingObject[A]] = {
    var ChildrenArray = ArrayBuffer(children: _*);

    // Promote
    var MaxDistance: Double = -1;
    var MaxPair = (-1, -1);
    for (i <- 0 to ChildrenArray.length - 1) {
      for (j <- i + 1 to ChildrenArray.length - 1) {
        val distance = ChildrenArray(j).center.minDist(ChildrenArray(i).center);
        if (distance > MaxDistance) {
          MaxDistance = distance;
          MaxPair = (i, j);
        }
      }
    }
    var op1 = ChildrenArray(MaxPair._1);
    var op2 = ChildrenArray(MaxPair._2);

    if (MaxPair._1 > MaxPair._2) {
      ChildrenArray.remove(MaxPair._1);
      ChildrenArray.remove(MaxPair._2);
    } else {
      ChildrenArray.remove(MaxPair._2);
      ChildrenArray.remove(MaxPair._1);
    }


    // Partition
    var N1 = ArrayBuffer[RoutingObject[A]]();
    N1.append(op1);
    var N2 = ArrayBuffer[RoutingObject[A]]();
    N2.append(op2);
    breakable {
      while (!ChildrenArray.isEmpty) {

        if (N2.length >= 2 && N1.length + ChildrenArray.length <= 2) {
          for (i <- 0 to ChildrenArray.length - 1) {
            var op1dist = ChildrenArray(i).center.minDist(op1.center);
            ChildrenArray(i).DistanceFromParent = op1dist;
            N1.append(ChildrenArray(i));
          }
          break;
        } else if (N1.length >= 2 && N2.length + ChildrenArray.length <= 2) {
          for (i <- 0 to ChildrenArray.length - 1) {
            var op2dist = ChildrenArray(i).center.minDist(op2.center);
            ChildrenArray(i).DistanceFromParent = op2dist;
            N2.append(ChildrenArray(i));
          }
          break;
        }

        var op1dist = ChildrenArray(0).center.minDist(op1.center);
        var op2dist = ChildrenArray(0).center.minDist(op2.center);
        if (op1dist <= op2dist) {
          ChildrenArray(0).DistanceFromParent = op1dist;
          N1.append(ChildrenArray(0));
        } else if (op2dist < op1dist) {
          ChildrenArray(0).DistanceFromParent = op2dist;
          N2.append(ChildrenArray(0));
        }
        ChildrenArray.remove(0);
      }
    }

    var op1Radius = -1.0;
    for (c <- N1) {
      val CurrentDistance = c.center.minDist(op1.center);
      c.DistanceFromParent = CurrentDistance;
      if (CurrentDistance + c.radius > op1Radius) op1Radius = CurrentDistance + c.radius;
    }

    var op2Radius = -1.0;
    for (c <- N2) {
      val CurrentDistance = c.center.minDist(op2.center);
      c.DistanceFromParent = CurrentDistance;
      if (CurrentDistance + c.radius > op2Radius) op2Radius = CurrentDistance + c.radius;
    }
    val op1Branch = new Branch[A](N1.toVector, op1.center);
    val op1RoutingObject = new RoutingObject[A](op1.center, op1Branch, 0, op1Radius);
    val op2Branch = new Branch[A](N2.toVector, op2.center);
    val op2RoutingObject = new RoutingObject[A](op2.center, op2Branch, 0, op2Radius);

    return Vector(op1RoutingObject, op2RoutingObject);
  }
}

case class Leaf[A](var children: Vector[Entry[A]],
                   var center: Point[Any], var num: Int = -1) extends Node[A] {
  def setLeafIndex(index: Int): Unit = {
    num = index
  }

  def getNum(): Int = num

  def split(m: Int): Vector[RoutingObject[A]] = {
    var ChildrenArray = ArrayBuffer(children: _*);
    // Promote
    var MaxDistance: Double = -1;
    var MaxPair = (-1, -1);
    for (i <- 0 to ChildrenArray.length - 1) {
      for (j <- i + 1 to ChildrenArray.length - 1) {
        val distance = ChildrenArray(j).center.minDist(ChildrenArray(i).center);
        if (distance > MaxDistance) {
          MaxDistance = distance;
          MaxPair = (i, j);
        }
      }
    }
    var op1 = ChildrenArray(MaxPair._1);
    var op2 = ChildrenArray(MaxPair._2);
    if (MaxPair._1 > MaxPair._2) {
      ChildrenArray.remove(MaxPair._1);
      ChildrenArray.remove(MaxPair._2);
    } else {
      ChildrenArray.remove(MaxPair._2);
      ChildrenArray.remove(MaxPair._1);
    }

    // Partition
    var N1 = ArrayBuffer[Entry[A]]();
    N1.append(op1);
    var N2 = ArrayBuffer[Entry[A]]();
    N2.append(op2);
    breakable {
      while (!ChildrenArray.isEmpty) {

        if (N2.length >= 2 && N1.length + ChildrenArray.length <= 2) {
          for (i <- 0 to ChildrenArray.length - 1) {
            var op1dist = ChildrenArray(i).center.minDist(op1.center);
            ChildrenArray(i).DistanceFromParent = op1dist;
            N1.append(ChildrenArray(i));
            // if (op1dist > op1Radius) op1Radius = op1dist;

          }
          break;
        } else if (N1.length >= 2 && N2.length + ChildrenArray.length <= 2) {
          for (i <- 0 to ChildrenArray.length - 1) {
            var op2dist = ChildrenArray(i).center.minDist(op2.center);
            ChildrenArray(i).DistanceFromParent = op2dist;
            N2.append(ChildrenArray(i));
            // if (op2dist > op2Radius) op2Radius = op2dist;

          }
          break;
        }

        var op1dist = ChildrenArray(0).center.minDist(op1.center);
        var op2dist = ChildrenArray(0).center.minDist(op2.center);
        if (op1dist <= op2dist) {
          ChildrenArray(0).DistanceFromParent = op1dist;
          N1.append(ChildrenArray(0));
          // if (op1dist > op1Radius) op1Radius = op1dist;
        } else if (op2dist < op1dist) {
          ChildrenArray(0).DistanceFromParent = op2dist;
          N2.append(ChildrenArray(0));
          // if (op2dist > op2Radius) op2Radius = op2dist;
        } /* else {
                        if (Math.random() > 0.5) {
                            ChildrenArray(0).DistanceFromParent = op1dist;
                            N1.append(ChildrenArray(0));
                            //if (op1dist > op1Radius) op1Radius = op1dist;
                        } else {
                            ChildrenArray(0).DistanceFromParent = op2dist;
                            N2.append(ChildrenArray(0));
                            //if (op2dist > op2Radius) op2Radius = op2dist;
                        }
                    } */
        ChildrenArray.remove(0);
      }
    }
    var op1Radius = -1.0;
    for (c <- N1) {
      val CurrentDistance = c.center.minDist(op1.center);
      c.DistanceFromParent = CurrentDistance;
      if (CurrentDistance > op1Radius) op1Radius = CurrentDistance;
    }
    assert(op1Radius != -1.0)

    var op2Radius = -1.0;
    for (c <- N2) {
      val CurrentDistance = c.center.minDist(op2.center);
      c.DistanceFromParent = CurrentDistance;
      if (CurrentDistance > op2Radius) op2Radius = CurrentDistance;
    }
    assert(op2Radius != -1.0)

    val op1Leaf = new Leaf[A](N1.toVector, op1.center);
    val op1RoutingObject = new RoutingObject[A](op1.center, op1Leaf, 0, op1Radius);
    val op2Leaf = new Leaf[A](N2.toVector, op2.center);
    val op2RoutingObject = new RoutingObject[A](op2.center, op2Leaf, 0, op2Radius);

    return Vector(op1RoutingObject, op2RoutingObject);
  }
}

case class RoutingObject[A](var center: Point[Any], var CoveringTree: Node[A],
                            var DistanceFromParent: Double, var radius: Double)

case class Entry[A](var center: Point[Any], var DistanceFromParent: Double, var value: A)