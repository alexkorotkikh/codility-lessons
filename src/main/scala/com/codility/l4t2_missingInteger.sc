// https://app.codility.com/programmers/lessons/4-counting_elements/missing_integer/

def solution(a: Array[Int]): Int = {
  if (a.isEmpty) return 1

  val cleaned = a.filter(_ > 0).sorted
  if (cleaned.isEmpty) return 1

  val min = cleaned(0)
  if (min - 1 > 0) return math.min(1, min)

  cleaned.indices.find(i =>
    i == cleaned.length - 1 ||
      (i < cleaned.length - 1 && cleaned(i + 1) > cleaned(i) + 1))
    .map(i => cleaned(i) + 1)
    .getOrElse(1)
}

assert(solution(Array(1, 3, 6, 4, 1, 2)) == 5)
assert(solution(Array(1, 2, 3)) == 4)
assert(solution(Array(-1, -3)) == 1)
assert(solution(Array()) == 1)
assert(solution(Array(2)) == 1)
assert(solution(Array(1)) == 2)
assert(solution(Array(-1000000, 1000000)) == 1)

// result: https://app.codility.com/demo/results/training6JVB72-DWA/