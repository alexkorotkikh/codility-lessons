object MaximumSubarray {
  def maxSubArray(nums: Array[Int]): Int = {
    nums.tail.foldLeft((nums(0), nums(0))) { case ((curr, max), next) =>
      if (curr <= 0 && next > curr) (next, math.max(next, max))
      else (curr + next, math.max(curr + next, max))
    }._2
  }
}