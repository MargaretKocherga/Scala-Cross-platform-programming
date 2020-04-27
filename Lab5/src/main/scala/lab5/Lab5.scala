package lab5

import scala.annotation.tailrec


object Lab5 extends App {

  /**
   * This method divides all even elements into 2 and adds 1 to all odd elements
   * using tail recursion.
   * @param list a list of natural numbers
   * @return changed list of natural numbers
   */
  def changeListTailRecursion(list: List[Int]): List[Int] = {
    @tailrec
    def iter(rem: List[Int], acc: List[Int]): List[Int] = {
      if(rem.isEmpty)
        acc.reverse
      else if(rem.head % 2 == 0)
        iter(rem.tail, (rem.head / 2)  :: acc)
      else
        iter(rem.tail, (rem.head + 1)  :: acc)
    }
    iter(list, Nil);
  }

  /**
   * This method divides all even elements into 2 and adds 1 to all odd elements
   * using non-tail recursion.
   * @param list a list of natural numbers
   * @return changed list of natural numbers
   */
  def changeListRecursion(list: List[Int]): List[Int] = {
    if(list.isEmpty) list
    else if(list.head % 2 == 0)
      (list.head / 2) :: changeListRecursion(list.tail)
    else (list.head + 1) :: changeListRecursion(list.tail)
  }

}
