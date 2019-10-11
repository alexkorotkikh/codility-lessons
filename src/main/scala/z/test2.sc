import scala.util.Random

object Solution2 {
  def solution(a: Array[Int], b: Array[Int]): Int = {
    val set = Set() ++ a.zip(b).map { case (ai, bi) => math.max(ai, bi) }
    val max = set.max
    (1 to max).find(n => !set.contains(n)).getOrElse(max + 1)
  }
}

val random = new Random()
assert(Solution2.solution(Array(1, 2, 4, 3), Array(1, 3, 2, 3)) == 2)
assert(Solution2.solution(Array(3, 2, 1, 6, 5), Array(4, 2, 1, 3, 3)) == 3)
assert(Solution2.solution(Array(1, 2), Array(1, 2)) == 3)
assert(Solution2.solution(Array.fill(100000)(random.nextInt()), Array.fill(100000)(random.nextInt())) == 1)