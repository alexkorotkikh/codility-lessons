// https://app.codility.com/programmers/lessons/3-time_complexity/perm_missing_elem/

def solution(a: Array[Int]): Int = {
  val (idxSum, elemSum) = (1 to a.length).foldLeft((0, 0)) { (tuple, i) =>
      val (s1, s2) = tuple
      (s1 + i, s2 + a(i - 1))
    }
  a.length + 1 - elemSum + idxSum
}

assert(solution(Array(1, 2, 5, 4)) == 3)
assert(solution(Array(1, 3, 5, 4)) == 2)
assert(solution(Array(1, 3)) == 2)
