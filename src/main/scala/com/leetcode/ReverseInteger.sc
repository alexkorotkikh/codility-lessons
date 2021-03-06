object ReverseInteger {
  def reverse(x: Int): Int = {
    val str = x.toString
    try {
      if (str.head == '-') ('-' + str.tail.reverse).toInt
      else str.reverse.toInt
    } catch { case _: NumberFormatException => 0 }
  }
}

assert(ReverseInteger.reverse(1534236469) == 0)