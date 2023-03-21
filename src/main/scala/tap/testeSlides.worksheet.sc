val lp = List(1,2,3,4,5)
lp.patch(2,Seq(99),2)

val list = List(("one", "i"), 
				("two", "2"), 
				("two", "ii"), 
				("one", "1"), 
				("four", "iv"))

                list.groupBy( (k,v) => k )
trait State
trait Green extends State
trait Yellow extends State
trait Red extends State

case class Semaphore[S <: State](id: String):
	def toYellow[T >: Green <: S]: Semaphore[Yellow] = copy[Yellow]()
	def toRed[T >: Yellow <: S]: Semaphore[Red] = copy[Red]()
	def toGreen[T >: Red <: S]: Semaphore[Green] = copy[Green]()

val s = Semaphore[Green]("My Semaphore")

class Animal { print("Animal-") }
trait Furry extends Animal { print("Furry-") }
trait HasLegs extends Animal { print("HasLegs-") }
trait FourLegged extends HasLegs { print("FourLegged-") }
class Cat extends Animal with Furry with FourLegged { print("Cat-") }
print(new Cat)

sealed trait Level
case object Full extends Level
case object HalfFull extends Level
case object Empty extends Level

case class Rocket private (fuel: Level)
object Rocket:
	def from(fuel: Level): Rocket =
		Rocket(fuel)
		
	def fly(r: Rocket) =
		if(r.fuel == Empty) "Cannot Fly!"
		else "Vrummm"

val r = Rocket.from(HalfFull)
Rocket.fly(r)

sealed trait Expr[+A] 
sealed case class Sum[A](a:Expr[A], b:Expr[A]) extends Expr[A] 
sealed case class Sub[A](a:Expr[A], b:Expr[A]) extends Expr[A] 
sealed case class Mul[A](a:Expr[A], b:Expr[A]) extends Expr[A] 
sealed case class Div[A](a:Expr[A], b:Expr[A]) extends Expr[A] 
sealed case class Val[A](v: A) extends Expr[A]

def eval(e: Expr[Int]):Int = e match { 
case Sum(a,b) => eval(a)+eval(b) 
case Sub(a,b) => eval(a)-eval(b) 
case Mul(a,b) => eval(a)*eval(b) 
case Div(a,b) => eval(a)/eval(b) 
case Val(v) => v }

eval(Sum(Val(1),Val(2)))

val v1 = 1
