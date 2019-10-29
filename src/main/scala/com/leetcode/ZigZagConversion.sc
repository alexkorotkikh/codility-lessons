object ZigZagConversion {
  def convert(s: String, numRows: Int): String = {
    if (numRows == 1) return s

    val ret = new StringBuilder
    val n = s.length
    val cycleLen = 2 * numRows - 2

    (0 until numRows).foreach { i =>
      (0 until n - i by cycleLen).foreach { j =>
        ret.append(s.charAt(j + i))
        if ((i != 0) && (i != numRows - 1) && j + cycleLen - i < n) {
          ret.append(s.charAt(j + cycleLen - i))
        }
      }
    }

    ret.toString()
  }
}

assert(ZigZagConversion.convert("PAYPALISHIRING", 3) == "PAHNAPLSIIGYIR")
assert(ZigZagConversion.convert("PAYPALISHIRING", 4) == "PINALSIGYAHRPI")