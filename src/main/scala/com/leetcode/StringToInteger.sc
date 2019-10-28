object StringToInteger {
  def myAtoi(str: String): Int = {
    @annotation.tailrec
    def _myAtoi(a: String, i: Int = 0, neg: Option[Boolean] = None): Int =
      a.headOption match {
        case None                                    => i
        case Some(c) if c.isSpaceChar && neg.isEmpty => _myAtoi(a.tail, i)
        case Some('+') if neg.isEmpty                => _myAtoi(a.tail, i, Some(false))
        case Some('-') if neg.isEmpty                => _myAtoi(a.tail, i, Some(true))
        case Some(c) if c.isDigit && neg.getOrElse(false) =>
          val int = c.asDigit
          if ((Int.MinValue + int) / 10.0 < i)
            _myAtoi(a.tail, i * 10 - int, neg)
          else Int.MinValue
        case Some(c) if c.isDigit && !neg.getOrElse(false) =>
          val int = c.asDigit
          if ((Int.MaxValue - int) / 10.0 > i)
            _myAtoi(a.tail, i * 10 + int, Some(false))
          else Int.MaxValue
        case _ => i
      }

    _myAtoi(str)
  }
}

assert(StringToInteger.myAtoi("42") == 42)
assert(StringToInteger.myAtoi("     -42") == -42)
assert(StringToInteger.myAtoi("4193 with words") == 4193)
assert(StringToInteger.myAtoi("words and 987") == 0)
assert(StringToInteger.myAtoi("-91283472332") == -2147483648)
assert(StringToInteger.myAtoi("+-2") == 0)
assert(StringToInteger.myAtoi("2147483646") == 2147483646)
assert(StringToInteger.myAtoi("0-1") == 0)