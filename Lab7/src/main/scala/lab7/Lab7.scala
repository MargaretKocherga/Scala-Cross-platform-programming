package lab7

object Lab7 {

  /**
   * This method checks list of bits (ones and zeros) for parity bits.
   * It checks if number of zeros in each 8 bits is even and if the 9th bit
   * is satisfactory.
   * @param bits list of bits to check
   * @return true if the list is satisfactory and false if not
   */
  def checkParityBit(bits: List[Int]): Boolean = {

    /**
     * Iteration method that helps to check list for parity bits.
     * @param bits list of bits to check
     * @param zeroNum number of zeros in 8 bits
     * @param iterNum number of iteration (number of bit)
     * @return true if the list is satisfactory and false if not
     */
    @scala.annotation.tailrec
    def iter(bits: List[Int], zeroNum: Int, iterNum: Int): Boolean = iterNum match {
      case 9 => bits.head match {
          case 0 => if (bits.tail.isEmpty)
              zeroNum % 2 != 0
            else  {
              if (zeroNum % 2 != 0) iter(bits.tail, 0, 1)
              else false
            }
          case 1 => if (bits.tail.isEmpty)
              zeroNum % 2 == 0
            else  {
              if (zeroNum % 2 == 0) iter(bits.tail, 0, 1)
              else false
            }
          case _ => throw new Exception("Wrong bit list format: not 1 or 0")
        }

      case _ => bits.head match {
        case 0 => iter(bits.tail, zeroNum + 1, iterNum + 1)
        case 1 => iter(bits.tail, zeroNum, iterNum + 1)
        case _ => throw new Exception("Wrong bit list format: not 1 or 0")
      }
    }

    if (bits.isEmpty) throw new NoSuchElementException("Empty bit list")
    else if (bits.size % 9 != 0) throw new Exception("Wrong bit list format: size not divisible to 9")
    else iter(bits, 0, 1)
  }

}
