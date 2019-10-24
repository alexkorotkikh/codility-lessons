object TwoSum {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    @annotation.tailrec
    def _twoSum(i: Int, map: Map[Int, Int]): Array[Int] = {
      map.get(target - nums(i)) match {
        case Some(j) => Array(j, i)
        case None    => _twoSum(i + 1, map + (nums(i) -> i))
      }
    }
    _twoSum(0, Map.empty)
  }
}

assert(TwoSum.twoSum(Array(2, 7, 11, 15), 9) sameElements Array(0, 1))