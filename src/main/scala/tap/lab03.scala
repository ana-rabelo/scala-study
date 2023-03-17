package tap

import scala.annotation.tailrec

object lab03:
  
  // #5
  def hasDigit[A](s: A):Boolean =
    s.toString().exists(_.isDigit)

  // #6
  def max_(xs: List[Int]): Option[Int] =
    @tailrec
    def maxAux(m: Int, ys: List[Int]): Int  = ys match 
      case Nil => m
      case x :: t => if (x > m) maxAux(x, t) else maxAux(m, t)
          
    if (xs.isEmpty) None else Some(maxAux(Int.MinValue,xs)) 

  // #7
  def applyF_[A,B](la: List[A],lb:List[B])(f: (List[A],List[B]) => String) : String =
    f(la,lb)

  def f1[A,B](la: List[A],lb:List[B]):String = 
    (la.map(_.toString) zip lb).flatMap(x  => Seq(x._1, x._2)).mkString

  def f2[A,B](la: List[A],lb:List[B]):String = la.concat(lb).mkString

  def f3[A,B](la: List[A],lb:List[B]):String = (la.reverse).concat(lb).mkString

  def f4[A,B](la: List[A],lb:List[B]):String =
    ???



