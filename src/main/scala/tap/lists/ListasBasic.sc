import scala.annotation.targetName
import scala.util.matching.Regex
import fansi.Str
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

//> c) OBS
bList.flatten :: aList :: Nil

//> d) OBS
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