// https://app.codility.com/programmers/lessons/16-greedy_algorithms/max_nonoverlapping_segments/

def solution(a: Array[Int], b: Array[Int]): Int = {
  if (a.length < 2) return a.length
  var count = 1
  var end = b(0)
  var index = 1
  while (index < a.length) {
    while (index < a.length && a(index) <= end) index += 1
    if (index == a.length) return count
    count += 1
    end = b(index)
  }
  count
}

assert(solution(Array(1), Array(2)) == 1)
assert(solution(Array(1, 3), Array(3, 5)) == 1)
assert(solution(Array(1, 2), Array(5, 3)) == 1)
assert(solution(Array(1, 3), Array(2, 4)) == 2)
assert(solution(Array(1, 3, 7, 9, 9), Array(5, 6, 8, 9, 10)) == 3)
assert(solution(Array(1, 3, 7, 9, 9), Array(5, 6, 8, 9, 10)) == 3)

// result: https://app.codility.com/demo/results/trainingE7AXWY-M2B/