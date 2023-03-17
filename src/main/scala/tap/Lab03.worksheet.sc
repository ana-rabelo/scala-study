import scala.annotation.tailrec
//  #1
val aList:List[Int] = List(1, 2, 3)
val bList=List("edom", "odsoft", "tap")
val cList=List('a', 'b')
val dList=List(true, false)
val e=5.6
val fList = List(1.0, 2, 3)
val g='i'

//> a)
bList.flatten

//> b)
bList.map(_.length)

//> c)
bList.flatten :: aList :: Nil

//> d)
dList :: List(e) :: Nil

//> e)
fList :: List(g.toString()) :: Nil 

//  #2
//> a) List.range
List.range(1, 10, 2)

//> b) List.tabulate
List.tabulate(5)(x => x * 2 + 1)


val l = List("Maria", "Ana", "Joana", "Julia", "Paulo", "José")

//  #3

//> a) 
l.filter(x => x.startsWith("Jo"))

//> b)
for (elem <- l if elem.startsWith("Jo")) yield elem

//  #4

val x = (i: Int) => if (i < 0) -i else i
List(1, 2, 3, -1, -2, -3, 0).map(x)
//> Result: List[Int] = List(1, 2, 3, 1, 2, 3, 0)

def applyF_[A,B](la: List[A],lb:List[B])(f: (List[A],List[B]) => String) : String =
    f(la,lb)

//res41: String = 19aa2b3c
def f1[A,B](la: List[A],lb:List[B]):String = 
    (la zip lb).flatMap(tuple => Seq(tuple._1, tuple._2)).mkString

def f2[A,B](la: List[A], lb:List[B]): String = la.concat(lb).mkString

def f3[A,B](la: List[A], lb:List[B]): String = (la.reverse).concat(lb).mkString

// 3291aabc
def f4[A,B](la: List[A], lb:List[B]): String = 
    (la.reverse).take(2).mkString + 
    ().toString.map(_.asDigit).mkString +
    lb.mkString


applyF_(List(19, 2, 3), List("aa", "b", "c"))(f4) 