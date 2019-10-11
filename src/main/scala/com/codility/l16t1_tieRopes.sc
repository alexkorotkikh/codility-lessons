// https://app.codility.com/programmers/lessons/16-greedy_algorithms/tie_ropes/

def solution(k: Int, a: Array[Int]): Int =
  a.foldLeft((0, 0)) { case ((t, res), next) =>
    if (t + next >= k) (0, res + 1)
    else (t + next, res)
  }._2

assert(solution(4, Array(1, 2)) == 0)
assert(solution(1, Array(1, 2)) == 2)
assert(solution(15, Array(1, 2, 3, 4, 5)) == 1)
assert(solution(4, Array(1, 2, 3, 4, 1, 1, 3)) == 3)

// result: https://app.codility.com/demo/results/trainingCFS2ZB-KN3/
