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
package org.apache.spark.sql.execution.dims.index.local

import scala.language.postfixOps
import collection.mutable
import org.apache.spark.sql.catalyst.expressions.dims.common.shape.Point
import VPTree._


/** VP-tree (vantage point tree) is a datastructure that can be used for
 * nearest-neighbour queries in arbitrary metric space.
 *
 * TODO http://boytsov.info/pubs/nips2013.pdf
 */
final class VPTree(val root: Tree) extends Serializable {
  def approximateNearest(t: Point[Any]): Point[Any] = root.approxNear(t)

  def approximateNearestN(t: Point[Any], n: Int): IndexedSeq[Point[Any]] = root.approxNearN(t, n)

  def nearest(t: Point[Any], maxDist: Double): IndexedSeq[Point[Any]] = root.nearN(t, maxDist)
}


object VPTree {


  /** Main constructor of VP-trees */
  def apply(items: IndexedSeq[Point[Any]], leafSize: Int): VPTree =
    new VPTree(mkNode(items, leafSize))

  sealed trait Tree {
    def size: Int

    def toSeq: IndexedSeq[Point[Any]]

    def approxNear(t: Point[Any]): Point[Any]

    def approxNearN(t: Point[Any], n: Int): IndexedSeq[Point[Any]]

    def nearN(t: Point[Any], maxDist: Double): IndexedSeq[Point[Any]]
  }

  final case class Node(point: Point[Any], radius: Double,
                        size: Int, in: Tree, out: Tree) extends Tree {
    def toSeq: IndexedSeq[Point[Any]] = in.toSeq ++ out.toSeq

    def approxNear(t: Point[Any]): Point[Any] = {
      val d = point.minDist(t)
      if (d < radius) in.approxNear(t)
      else out.approxNear(t)
    }

    def approxNearN(t: Point[Any], n: Int): IndexedSeq[Point[Any]] =
      if (n <= 0) IndexedSeq()
      else if (n > size) toSeq
      else {
        val d = point.minDist(t)
        if (d < radius) {
          in.approxNearN(t, n) ++ out.approxNearN(t, n - in.size)
        } else {
          out.approxNearN(t, n) ++ in.approxNearN(t, n - out.size)
        }
      }

    def nearN(t: Point[Any], maxDist: Double): IndexedSeq[Point[Any]] = {
      val d = point.minDist(t)
      if (d + maxDist < radius) {
        in.nearN(t, maxDist)
      } else if (d - maxDist >= radius) {
        out.nearN(t, maxDist)
      } else {
        in.nearN(t, maxDist) ++ out.nearN(t, maxDist)
      }
    }
  }

  final case class Leaf(points: IndexedSeq[Point[Any]]) extends Tree {
    def size: Int = points.length

    def toSeq: IndexedSeq[Point[Any]] = points

    def approxNear(t: Point[Any]): Point[Any] = points minBy (p => p.minDist(t))

    def approxNearN(t: Point[Any], n: Int): IndexedSeq[Point[Any]] =
      if (n <= 0) IndexedSeq()
      else if (n >= size) points
      else points sortBy (p => p.minDist(t)) take n

    def nearN(t: Point[Any], maxDist: Double): IndexedSeq[Point[Any]] =
      points filter { p => t.minDist(p) <= maxDist }
  }

  def mkNode(items: IndexedSeq[Point[Any]], leafSize: Int): Tree = {
    if (items.length <= leafSize) {
      Leaf(items)
    } else {
      val vp = items(util.Random.nextInt(items.length))

      val radius = {
        val numSamples = math.sqrt(items.length).toInt * 2
        val distances = pickSample(items, numSamples).map(i => vp.minDist(i)).toArray
        java.util.Arrays.sort(distances)
        distances(distances.length / 2)
      }

      val (in, out) = items partition { item => item.minDist(vp) < radius }

      if (in.length == 0) Leaf(out)
      else if (out.length == 0) Leaf(in)
      else Node(vp, radius, items.length, mkNode(in, leafSize), mkNode(out, leafSize))
    }
  }

  def pickSample(items: IndexedSeq[Point[Any]], size: Int): IndexedSeq[Point[Any]] =
    if (items.length <= size) items
    else IndexedSeq.fill(size)(items(util.Random.nextInt(items.length)))

  def balance(t: Tree): List[(Int, Int)] = t match {
    case Leaf(_) => Nil
    case Node(_, _, _, in, out) => List((in.size, out.size)) ::: balance(in) ::: balance(out)
  }

  //  def prettyPrint(n: Tree, offset: Int = 0): String = n match {
  //    case Leaf(points) =>
  //      (" " * offset) + "Leaf(" + points.mkString(",") + ")\n"
  //    case n: Node[_] =>
  //      (" " * offset) + "Node(point = " + n.point + ", radius = " + n.radius + "\n" +
  //        prettyPrint(n.in, offset + 2) +
  //        prettyPrint(n.out, offset + 2) +
  //        (" " * offset) + ")\n"
  //  }
}