package lab6

object Lab6 {

  /**
   * This method creates a new list from two original lists using combine function.
   * @param list1 the first list of natural numbers
   * @param list2 the second list of natural numbers
   * @param combine a function that defines how an element of the new list
   *                will be obtained from two elements of the original lists
   * @return new list of natural numbers
   */
  def mapLists(list1: List[Int], list2: List[Int], combine: (Int, Int) => Int): List[Int] = {
    if( list1.isEmpty && list2.isEmpty ) List()
    else if( list1.isEmpty ) list2
    else if( list2.isEmpty ) list1
    else combine(list1.head, list2.head) :: mapLists(list1.tail, list2.tail, combine)
  }
}
