object FourSum {
  def fourSum(nums: Array[Int], target: Int): List[List[Int]] = {
    val counts = nums.groupBy(identity).mapValues(_.length)
    val uniqueNumbers = counts.keys.toList.sorted

    val map = (for {
      a <- uniqueNumbers
      b <- uniqueNumbers
      res = a + b
      if a <= b && (a != b || counts(a) > 1)
    } yield
      res -> (a, b)).groupBy(_._1).mapValues(e => e.map(x => x._2).toSet)

    map
      .flatMap {
        case (ab: Int, set) =>
          set.flatMap {
            case (a, b) =>
              val cd = target - ab
              map
                .getOrElse(cd, Set())
                .filter {
                  case (c, d) =>
                    List(a, b, c, d)
                      .groupBy(identity)
                      .mapValues(_.length)
                      .forall { case (v, count) => counts(v) >= count }
                }
                .map {
                  case (c, d) => List(a, b, c, d).sorted
                }
          }
      }
      .toSet
      .toList
  }
}

//FourSum.fourSum(Array(1, 0, -1, 0, -2, 2), 0)
FourSum.fourSum(Array(-3, -2, -1, 0, 0, 3), 0)