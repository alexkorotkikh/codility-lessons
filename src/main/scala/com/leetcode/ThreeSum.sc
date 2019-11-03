object ThreeSum {
  def threeSum(nums: Array[Int]): List[List[Int]] = {
    val numbersCount = nums.groupBy(identity).view.mapValues(_.length)
    val uniqueNumbers = numbersCount.keys.toList.sorted

    for {
      a <- uniqueNumbers
      b <- uniqueNumbers
      if a <= b && (a != b || numbersCount(a) > 1)
      c = -a - b
      if b <= c
      candidate = List(a, b, c)
      if numbersCount.getOrElse(c, 0) >= candidate.count(_ == c)
    } yield candidate
  }
}