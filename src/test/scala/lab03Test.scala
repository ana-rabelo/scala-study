package tap

import scala.language.adhocExtensions

import org.scalatest.funsuite.AnyFunSuite

class ListasFuncTest extends AnyFunSuite:
  test("hasDigit") {
    assert(ListasFunc.hasDigit("asd1asd")===true)
    assert(ListasFunc.hasDigit("asdasd")===false)
    assert(ListasFunc.hasDigit(List("asd", "a1"))===true)
    assert(ListasFunc.hasDigit(Set("asd", "a1"))===true)
    assert(ListasFunc.hasDigit(1)===true)
    assert(ListasFunc.hasDigit('1')===true)
    assert(ListasFunc.hasDigit(List(Set("a", "b"), Set("a1", "d"),Set("b", "c")))===true)
    assert(ListasFunc.hasDigit('a') ===false)
    assert(ListasFunc.hasDigit("")===false)
    assert(ListasFunc.hasDigit(('a',"ana"))===false)
  }

  test("max_") {
    assert(ListasFunc.max_(List(1,2,3,4))===Some(4))
    assert(ListasFunc.max_(List(1))===Some(1))
  }

  test("max_ with empty list") {
    assert(ListasFunc.max_(List())===None)
  }

  test("applyF_") {
    assert(ListasFunc.applyF_(List(19, 2, 3), List("aa", "b", "c"))(ListasFunc.f1) === "19aa2b3c")
    assert(ListasFunc.applyF_(List(19, 2, 3), List("aa", "b", "c"))(ListasFunc.f2) === "1923aabc")
    assert(ListasFunc.applyF_(List(19, 2, 3), List("aa", "b", "c"))(ListasFunc.f3) === "3219aabc")
    //assert(ListasFunc.applyF_(List(19, 2, 3), List("aa", "b", "c"))(ListasFunc.f4) === "3291aabc")
  }
  test("applyF_ with empty lists") {
    assert(ListasFunc.applyF_(List(), List("aa", "b", "c"))(ListasFunc.f1) === "")
    assert(ListasFunc.applyF_(List(), List("aa", "b", "c"))(ListasFunc.f2) === "aabc")
    assert(ListasFunc.applyF_(List(), List("aa", "b", "c"))(ListasFunc.f3) === "aabc")
   // assert(ListasFunc.applyF_(List(), List("aa", "b", "c"))(ListasFunc.f4) === "aabc")

    assert(ListasFunc.applyF_(List(19, 2, 3), List())(ListasFunc.f1) === "")
    assert(ListasFunc.applyF_(List(19, 2, 3), List())(ListasFunc.f2) === "1923")
    assert(ListasFunc.applyF_(List(19, 2, 3), List())(ListasFunc.f3) === "3219")
    //assert(ListasFunc.applyF_(List(19, 2, 3), List())(ListasFunc.f4) === "3291")

    assert(ListasFunc.applyF_(List(), List())(ListasFunc.f1) === "")
    assert(ListasFunc.applyF_(List(), List())(ListasFunc.f2) === "")
    assert(ListasFunc.applyF_(List(), List())(ListasFunc.f3) === "")
    //assert(ListasFunc.applyF_(List(), List())(ListasFunc.f4) === "")
  }
