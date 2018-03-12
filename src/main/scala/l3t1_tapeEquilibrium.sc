// https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/

def solution(a: Array[Int]): Int = {
  var leftSum = 0
  var rightSum = a.sum
  var min = 2000
  a.dropRight(1).foreach { num =>
    leftSum += num
    rightSum -= num
    val diff = math.abs(leftSum - rightSum)
    if (diff == 0) {
      return 0
    }
    min = math.min(min, diff)
  }
  min
}

assert(solution(Array(3, 1, 2, 4, 3)) == 1)
assert(solution(Array(3, 1, 3, 4, 3)) == 0)
assert(solution(Array(-1000, 1000)) == 2000)
