// https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/

def solution(a: Int, b: Int, k: Int): Int = {
  val aMod = a % k
  val firstDiv = if (aMod == 0) a else a + (k - aMod)
  val lastDiv = b - (b % k)
  math.max((lastDiv - firstDiv) / k + 1, 0)
}

assert(solution(6, 11, 2) == 3)
assert(solution(6, 11, 7) == 1)
assert(solution(6, 11, 12) == 0)
assert(solution(6, 6, 6) == 1)

// result: https://app.codility.com/demo/results/training2NAPW8-EGS/