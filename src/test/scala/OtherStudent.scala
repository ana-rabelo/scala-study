package tap

import scala.language.adhocExtensions
import org.scalatest.funsuite.AnyFunSuite

class OtherStudentTest extends AnyFunSuite:

  import OtherStudent.*
  
  test("Idade negativa") {
    assert( OtherStudent.from("Ana", "Silva", -1) === None )
  }

  test("Nomes não têm só letras") {
    assert( OtherStudent.from("An0a", "Silva", 25) === None )
    assert( OtherStudent.from("Ana", "Sil&va", 25) === None )
    assert( OtherStudent.from("!Ana", "Silva", 25) === None )
    assert( OtherStudent.from("A na", "Silva", 25) === None )
    assert( OtherStudent.from("A0na Silva Paula", -25) === None )
  }

  test("Estudante Correto") {
    val fn = "Ana"
    val ln = "Silva"
    val age = 25
    val os = OtherStudent.from(fn, ln, age)
    val r = os.fold(false)(s => s.firstName==fn && s.lastName==ln && s.age == age)
    assert( r )
  }

  test("Estudante Correto - nome longo") {
    val fn = "Ana"
    val ln = "Silva"    
    val n = fn + " Julia "+ ln
    val age = 26
    val os = OtherStudent.from(n, age)
    val r = os.fold(false)(s => s.firstName==fn && s.lastName==ln && s.age == age)
    assert( r )
  }

