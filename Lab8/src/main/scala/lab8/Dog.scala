package lab8

import scala.util.parsing.combinator.RegexParsers

/**
 * Enum object for command handling.
 */
object Commands extends Enumeration {
  val Sit, Stand, Eat, Name = Value
}

/**
 * Dog class.
 * @param name name of the dog
 */
class Dog(val name: String) {

  /**
   * Method to handle commands.
   * @param command passed command to the dog
   * @return string with response to commands
   */
  def commandHandling(command: Commands.Value): String = command match {
    case Commands.Sit => "Dog is sitting."
    case Commands.Stand => "Dog is standing."
    case Commands.Name => "Woof!"
    case Commands.Eat => "Woof-woof!"
  }

  /**
   * Object for parsing commands.
   * Now you can enter case insensitive words as "EAT", "eat", "eAt"
   * and not only word, but strings, such as "SIT YOU PIECE OF DOG!"
   */
  object ParseCommands extends RegexParsers {
    def eatParser: Parser[String] = "(?i)\\b(eat)\\b".r ^^ (_ => commandHandling(Commands.Eat))
    def sitParser: Parser[String] = "(?i)\\b(sit)\\b".r ^^ (_ => commandHandling(Commands.Sit))
    def standParser: Parser[String] = "(?i)\\b(stand)\\b".r ^^ (_ => commandHandling(Commands.Stand))
    def nameParser: Parser[String] = Dog.this.name ^^ (_ => commandHandling(Commands.Name))

    def commandParser: Parser[String] = eatParser | sitParser | standParser | nameParser
  }

  /**
   * Method for checking if parsing was successful.
   * @param string passed command to the dog
   * @return result if parsing was successful and throws an exception in case of failure.
   */
  def parseString(string: String): String =  ParseCommands.parse(ParseCommands.commandParser, string) match {
    case _: ParseCommands.Failure => throw new RuntimeException("Cannot parse " + string)
    case result => result.get
  }
}

/**
 * Companion object for dog naming.
 */
object Dog {
  def apply(name: String) = new Dog(name)
}


