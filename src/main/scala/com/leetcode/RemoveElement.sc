object RemoveElement {
  def removeElement(nums: Array[Int], v: Int): Int = {
    var i = 0
    var n = nums.length
    while (i < n) {
      if (nums(i) == v) { nums(i) = nums(n - 1); n -= 1 }
      else i += 1
    }
    n
  }
}