

trait Tree[+A]

case object EmptyTree extends Tree[Nothing]

final case class Node[A](elem: A, left: Tree[A], right: Tree[A]) extends Tree[A]

object TreeOps:  
  def contains[A <: Comparable[A]](t: Tree[A], v: A): Boolean = t match
    case EmptyTree => false

  def insert[A <: Comparable[A]](t: Tree[A], v: A): Tree[A] = t match
    case EmptyTree => Node(v, EmptyTree, EmptyTree)
    case Node(elem, left, right) => 
      if (v.compareTo(elem) < 0) Node(elem, insert(left, v), right) else Node(elem, left, insert(right, v))