// https://app.codility.com/programmers/lessons/6-sorting/triangle/

def solution(a: Array[Int]): Int = {
    if (a.length < 3) return 0
    val sorted = a.sorted
    sorted.indices
      .dropRight(2)
      .find(i =>
        sorted(i) + sorted(i + 1) > sorted(i + 2) ||
          sorted(i) > sorted(i + 2) - sorted(i + 1)) // for int overflow case
      .map(_ => 1).getOrElse(0)
}

assert(solution(Array()) == 0)
assert(solution(Array(1)) == 0)
assert(solution(Array(1, 3)) == 0)
assert(solution(Array(10, 50, 5, 1)) == 0)
assert(solution(Array(2, 5, 6)) == 1)
assert(solution(Array(5, 3, 3)) == 1)
assert(solution(Array(10, 2, 5, 1, 8, 20)) == 1)
assert(solution(Array.fill(3)(Int.MaxValue)) == 1)
assert(solution(Array.fill(3)(Int.MinValue)) == 1)

// result https://app.codility.com/demo/results/trainingGBST7Z-JZS/