package lab5

import org.scalatest._

/**
 * This class implements a scalatest suite for the methods in object
 * `Lab5`.
 */
class Lab5Suite extends FunSuite {

  test("Change List(1, 2, 3) with tail recursion") {
    assert(Lab5.changeListTailRecursion(List(1, 2, 3)) === List(2, 1, 4))
  }

  test("Change List(1, 2, 3) with non-tail recursion") {
    assert(Lab5.changeListRecursion(List(1, 2, 3)) === List(2, 1, 4))
  }


  test("Change empty list with tail recursion") {
    assert(Lab5.changeListTailRecursion(List()) === List())
  }

  test("Change empty list with non-tail recursion") {
    assert(Lab5.changeListRecursion(List()) === List())
  }


  test("Change List(-8, 0, 15) with tail recursion") {
    assert(Lab5.changeListTailRecursion(List(-8, 0, 15)) === List(-4, 0, 16))
  }

  test("Change List(-8, 0, 15) with non-tail recursion") {
    assert(Lab5.changeListRecursion(List(-8, 0, 15)) === List(-4, 0, 16))
  }


  test("Change List(100, -234, 561, 3, 14) with tail recursion") {
    assert(Lab5.changeListTailRecursion(List(100, -234, 561, 3, 14)) === List(50, -117, 562, 4, 7))
  }

  test("Change List(100, -234, 561, 3, 14) with non-tail recursion") {
    assert(Lab5.changeListRecursion(List(100, -234, 561, 3, 14)) === List(50, -117, 562, 4, 7))
  }

}
