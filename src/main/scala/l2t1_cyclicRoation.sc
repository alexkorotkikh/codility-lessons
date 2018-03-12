// https://app.codility.com/programmers/lessons/2-arrays/cyclic_rotation/

def solution(a: Array[Int], k: Int): Array[Int] = {
  if (a.isEmpty || a.length == 1) a
  else {
    val rot = if (a.length < k) k % a.length else k
    a.takeRight(rot) ++ a.dropRight(rot)
  }
}


assert(solution(Array(3, 8, 9, 7, 6), 3) sameElements Array(9, 7, 6, 3, 8))
assert(solution(Array(3, 8, 9, 7, 6), 8) sameElements Array(9, 7, 6, 3, 8))
assert(solution(Array(1, 2, 3, 4), 4) sameElements Array(1, 2, 3, 4))
assert(solution(Array(0, 0, 0), 1) sameElements Array(0, 0, 0))
