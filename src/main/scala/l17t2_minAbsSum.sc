// https://app.codility.com/programmers/lessons/17-dynamic_programming/min_abs_sum/

  def solution(a: Array[Int]): Int = {
    if (a.length == 0) return 0
    val arr = a.map(math.abs)
    val max = arr.max
    val sum = arr.sum
    val count = Array.fill(max + 1)(0)
    arr.indices.foreach(i => count(arr(i)) += 1)
    val dp = Array(0) ++ Array.fill(sum)(-1)
    (1 to max).foreach { i =>
      if (count(i) > 0) {
        (0 until sum).foreach { j =>
          if (dp(j) >= 0) dp(j) = count(i)
          else if (j >= i && dp(j - i) > 0) dp(j) = dp(j - i) - 1
        }
      }
    }
    var res = sum
    (0 until sum / 2 + 1).foreach { i =>
      if (dp(i) >= 0) res = math.min(res, sum - 2 * i)
    }
    res
  }

assert(solution(Array.empty) == 0)
assert(solution(Array(5)) == 5)
assert(solution(Array(5, 5)) == 0)
assert(solution(Array(4, 5)) == 1)
assert(solution(Array(1, 5, 2, -2)) == 0)

// result: https://app.codility.com/demo/results/trainingH849ZX-6PN/