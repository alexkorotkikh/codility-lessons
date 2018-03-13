// https://app.codility.com/programmers/lessons/4-counting_elements/frog_river_one/

import scala.collection.mutable

def solution(x: Int, a: Array[Int]): Int = {
  val neededLeaves = mutable.Set[Int]()
  var lastLeaveTime = a.length
  a.indices.foreach { i =>
    if (a(i) <= x) {
      neededLeaves add a(i)
      if (i < lastLeaveTime && neededLeaves.size == x) {
        lastLeaveTime = i
      }
    }
  }
  if (neededLeaves.size == x) lastLeaveTime
  else -1
}

assert(solution(5, Array(1, 3, 1, 4, 2, 3, 5, 4)) == 6)
assert(solution(5, Array(1, 3, 1, 4, 2, 3, 4)) == -1)
assert(solution(5, Array(1, 3, 1, 4, 3, 5, 4)) == -1)
assert(solution(5, Array(1, 3, 1, 4, 3, 5, 2, 4)) == 6)
assert(solution(1, Array(1)) == 0)






