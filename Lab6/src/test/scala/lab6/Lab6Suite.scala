package lab6

import org.scalatest._

/**
 * This class implements a scalatest suite for the method `mapLists`
 * in object `Lab6`.
 */
class Lab6Suite extends FunSuite {
  test("List() + List()") {
    assert(Lab6.mapLists(List(), List(), (x, y) => x + y) === List())
  }

  test("List() - List()") {
    assert(Lab6.mapLists(List(), List(), (x, y) => x - y) === List())
  }

  test("List(1, 2, 3) + List(2)") {
    assert(Lab6.mapLists(List(1, 2, 3), List(2), (x, y) => x + y) === List(3, 2, 3))
  }

  test("List(1, 2, 3) - List(2)") {
    assert(Lab6.mapLists(List(1, 2, 3), List(2), (x, y) => x - y) === List(-1, 2, 3))
  }

  test("List(1, 2, 3, 4, 5) + List(0, -1, 2, -3, 4)") {
    assert(Lab6.mapLists(List(1, 2, 3, 4, 5), List(0, -1, 2, -3, 4), (x, y) => x + y) === List(1, 1, 5, 1, 9))
  }

  test("List(1, 2, 3, 4, 5) - List(0, -1, 2, -3, 4)") {
    assert(Lab6.mapLists(List(1, 2, 3, 4, 5), List(0, -1, 2, -3, 4), (x, y) => x - y) === List(1, 3, 1, 7, 1))
  }

  test("List(-10, 20, 15, 5000, -300, 0, 10) + List(100, 356, -20, 2, 3000, -7000, 9, 100, -15)") {
    assert(Lab6.mapLists(List(-10, 20, 15, 5000, -300, 0, 10), List(100, 356, -20, 2, 30000, -7000, 9, 100, -15),
      (x, y) => x + y) === List(90, 376, -5, 5002, 29700, -7000, 19, 100, -15))
  }

  test("List(-10, 20, 15, 5000, -300, 0, 10) - List(100, 356, -20, 2, 3000, -7000, 9, 100, -15)") {
    assert(Lab6.mapLists(List(-10, 20, 15, 5000, -300, 0, 10), List(100, 356, -20, 2, 30000, -7000, 9, 100, -15),
      (x, y) => x - y) === List(-110, -336, 35, 4998, -30300, 7000, 1, 100, -15))
  }
}
