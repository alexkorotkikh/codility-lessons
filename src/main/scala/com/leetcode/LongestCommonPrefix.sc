object LongestCommonPrefix {
  def longestCommonPrefix(strs: Array[String]): String = {
    def common(a: String, b: String): String = {
      var i = 0
      while (i < a.length && i < b.length && a(i) == b(i)) i += 1
      a.substring(0, i)
    }
    if (strs.isEmpty) ""
    else if (strs.length == 1) strs.head
    else strs.tail.foldLeft(strs.head) { case (acc, str) => common(acc, str) }
  }
}

assert(
  LongestCommonPrefix
    .longestCommonPrefix(Array("flower", "flow", "flight")) == "fl"
)
assert(
  LongestCommonPrefix
    .longestCommonPrefix(Array("dog", "racecar", "car")) == ""
)