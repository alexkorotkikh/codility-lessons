// https://app.codility.com/programmers/lessons/15-caterpillar_method/min_abs_sum_of_two/

def solution(a: Array[Int]): Int = {
  val arr = a.sorted
  if (arr.head >= 0) math.abs(arr.head + arr.head)
  else if (arr.last <= 0) math.abs(arr.last + arr.last)
  else {
    var min = math.abs(arr.last + arr.last)
    var (low, high) = (0, arr.length - 1)
    while (low <= high) {
      val t = math.abs(arr(low) + arr(high))
      if (t < min) min = t
      if (math.abs(arr(low + 1) + arr(high)) <= t) low += 1
      else if (math.abs(arr(low) + arr(high - 1)) <= t) high -= 1
      else {
        low += 1
        high -= 1
      }
    }
    min
  }
}

assert(solution(Array(1)) == 2)
assert(solution(Array(1, 2)) == 2)
assert(solution(Array(1, -1)) == 0)
assert(solution(Array(1, -1, 0)) == 0)
assert(solution(Array(-1, -2, -3)) == 2)

// result: https://app.codility.com/demo/results/training9R25NY-KG8/