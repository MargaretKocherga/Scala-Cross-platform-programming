package lab8

import org.scalatest._

/**
 * This class implements a scalatest suite
 * for the class `Dog`.
 */
class DogSuite extends FunSuite {

  test("Check name handling.") {
    val dog = Dog("Mike")
    assert(dog.parseString("Mike, good boy!") === "Woof!")
  }

  test("Check sit command handling.") {
    val dog = Dog("Hannah")
    assert(dog.parseString("Sit!!!") === "Dog is sitting.")
  }

  test("Check stand command handling.") {
    val dog = Dog("Jack")
    assert(dog.parseString("Stand already!") === "Dog is standing.")
  }

  test("Check feeding.") {
    val dog = Dog("Mike")
    assert(dog.parseString("Eat, boy!") === "Woof-woof!")
  }

  test("Catching exception with non-existing command: Cannot parse Jump, jump, jump!") {
    val dog = Dog("Bob")

    val thrown = intercept[Exception] {
      dog.parseString("Jump, jump, jump!")
    }
    assert(thrown.getMessage === "Cannot parse Jump, jump, jump!")
  }

}
