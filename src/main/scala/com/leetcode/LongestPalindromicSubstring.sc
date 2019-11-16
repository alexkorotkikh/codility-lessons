object LongestPalindromicSubstring {
  def longestPalindrome(s: String): String = {
    if (s == null || s.isEmpty) return ""
    var start = 0
    var end = 0
    s.indices.foreach { i =>
      val len1 = expandAroundCenter(s, i, i)
      val len2 = expandAroundCenter(s, i, i + 1)
      val len = Math.max(len1, len2)
      if (len > end - start) {
        start = i - (len - 1) / 2
        end = i + len / 2
      }
    }
    s.substring(start, end + 1)
  }

  def expandAroundCenter(s: String, left: Int, right: Int) = {
    var l = left
    var r = right
    while (l >= 0 && r < s.length && s.charAt(l) == s.charAt(r)) {
      l -= 1
      r += 1
    }
    r - l - 1
  }
}