// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_slice_sum/

def solution(a: Array[Int]): Int = {
  a.drop(1).foldLeft((a(0), a(0))) { (acc, x) =>
    var (maxEnding, maxSlice) = acc
    maxEnding = math.max(x, maxEnding + x)
    maxSlice = math.max(maxEnding, maxSlice)
    (maxEnding, maxSlice)
  }._2
}

assert(solution(Array(-10)) == -10)
assert(solution(Array(3, 2, -6, 4, 0)) == 5)

// result: https://app.codility.com/demo/results/trainingZXPZST-28C/