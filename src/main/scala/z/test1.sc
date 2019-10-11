import scala.annotation.tailrec

object Solution {
  def solution(n: Int, k: Int): Int = {
    @tailrec
    def _solution(n: Int, k: Int, acc: Int): Int = {
      if (k == 0) acc + n - 1
      else if (n <= 1) acc
      else if (n % 2 == 1) _solution(n - 1, k, acc + 1)
      else _solution(n / 2, k - 1, acc + 1)
    }

    _solution(n, k, 0)
  }
}

assert(Solution.solution(8, 0) == 7)
assert(Solution.solution(18, 2) == 6)
assert(Solution.solution(10, 10) == 4)
assert(Solution.solution(1, 0) == 0)
assert(Solution.solution(1, 100) == 0)
assert(Solution.solution(2147483647, 0) == 2147483646)
assert(Solution.solution(2147483647, 60) == 2147483646)
