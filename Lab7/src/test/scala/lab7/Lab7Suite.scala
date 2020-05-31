package lab7

import org.scalatest._

/**
 * This class implements a scalatest suite for the method `checkParityBit`
 * in object `Lab7`.
 */
class Lab7Suite extends FunSuite {

  test("Catching exception: Wrong bit list format: not 1 or 0") {
    val thrown = intercept[Exception] {
      Lab7.checkParityBit(List(1, 1, 0, 0, 1, 7, 1, 1, 1,
        1, 1, 0, 0, 1, 1, 1, 1, 3,
        1, 1, 2, 1, 1, 0, 1, 1, 1,
        0, 1, 0, 1, 0, 1, 1, 1, 0))
    }
    assert(thrown.getMessage === "Wrong bit list format: not 1 or 0")
  }

  test("Catching exception: Wrong bit list format: size not divisible to 9") {
    val thrown = intercept[Exception] {
      Lab7.checkParityBit(List(1, 1, 0, 0, 1, 1, 1, 1, 1,
        1, 1, 0, 0, 1, 1, 1, 1, 1,
        1, 1, 0, 1, 1, 0, 1, 1, 1,
        0, 1, 0, 1, 0, 1, 1, 0))
    }
    assert(thrown.getMessage === "Wrong bit list format: size not divisible to 9")
  }

  test("Catching exception with small bit list: Wrong bit list format: size not divisible to 9") {
    val thrown = intercept[Exception] {
      Lab7.checkParityBit(List(1, 1, 0))
    }
    assert(thrown.getMessage === "Wrong bit list format: size not divisible to 9")
  }

  test("Catching exception: Empty bit list") {
    val thrown = intercept[NoSuchElementException] {
      Lab7.checkParityBit(List())
    }
    assert(thrown.getMessage === "Empty bit list")
  }

  test("Correct list of bits") {
    assert(Lab7.checkParityBit(List(1, 1, 0, 0, 1, 1, 1, 1, 1)) === true)
  }

  test("Really long correct list of bits") {
    assert(Lab7.checkParityBit(List(1, 1, 0, 0, 1, 1, 1, 1, 1,
      1, 1, 0, 0, 1, 1, 1, 1, 1,
      1, 1, 0, 1, 1, 0, 1, 1, 1,
      0, 1, 0, 1, 0, 1, 1, 1, 0)) === true)
  }

  test("Wrong list of bits") {
    assert(Lab7.checkParityBit(List(1, 1, 0, 0, 1, 1, 0, 1, 1)) === false)
  }

  test("Really long wrong list of bits") {
    assert(Lab7.checkParityBit(List(1, 1, 0, 0, 1, 1, 1, 1, 1,
      1, 1, 0, 0, 1, 1, 1, 1, 0,
      1, 1, 0, 1, 1, 0, 1, 1, 1,
      0, 1, 0, 1, 0, 1, 1, 1, 0)) === false)
  }

}
