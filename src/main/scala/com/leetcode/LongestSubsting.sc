object LongestSubstring {
  def lengthOfLongestSubstring(s: String): Int = {
    val set = collection.mutable.Set[Char]()
    var i, j, max = 0
    while (i < s.length && j < s.length) {
      if (!set.contains(s.charAt(j))) {
        set.add(s.charAt(j))
        j += 1
        max = math.max(max, j - i)
      } else {
        set.remove(s.charAt(i))
        i += 1
      }
    }
    max
  }
}

assert(LongestSubstring.lengthOfLongestSubstring("abcabcbb") == 3)
assert(LongestSubstring.lengthOfLongestSubstring("bbbbb") == 1)
assert(LongestSubstring.lengthOfLongestSubstring("pwwkew") == 3)
assert(LongestSubstring.lengthOfLongestSubstring("dvdf") == 3)