// https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/

def solution(a: Array[Int]): Int = {
  val sorted = a.sorted
  val n = sorted.length
  math.max(
    sorted(n - 1) * sorted(n - 2) * sorted(n - 3),
    sorted(0) * sorted(1) * sorted(n - 1)
  )
}

assert(solution(Array(1, 2, 3)) == 6)
assert(solution(Array(-3, 1, 2, -2, 5, 6)) == 60)
assert(solution(Array(-5, 5, -5, 4)) == 125)

// result: https://app.codility.com/demo/results/training26GPJ4-3WJ/