// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_profit/

def solution(a: Array[Int]): Int = {
  if (a.length <= 1) 0
  else a.drop(1).foldLeft((0, 0, a(0))) { (acc, x) =>
    var (maxEnding, maxSlice, minPrice) = acc
    maxEnding = math.max(0, x - minPrice)
    maxSlice = math.max(maxEnding, maxSlice)
    minPrice = math.min(x, minPrice)
    (maxEnding, maxSlice, minPrice)
  }._2
}

assert(solution(Array()) == 0)
assert(solution(Array(23171)) == 0)
assert(solution(Array(23171, 21011, 21123, 21366, 21013, 21367)) == 356)

// result: https://app.codility.com/demo/results/trainingM925G8-HHE/
