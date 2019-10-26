object PalindromeNumber {
  def isPalindrome(x: Int): Boolean = {
    if (x < 0 || (x % 10 == 0 && x != 0)) false
    else {
      var original = x
      var reversed = 0
      while (original > reversed) {
        reversed = reversed * 10 + original % 10
        original = original / 10
      }
      original == reversed || original == reversed / 10
    }
  }
}

assert(PalindromeNumber.isPalindrome(1))
assert(PalindromeNumber.isPalindrome(101))
assert(!PalindromeNumber.isPalindrome(100))
assert(PalindromeNumber.isPalindrome(1001))