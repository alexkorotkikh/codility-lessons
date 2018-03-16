// https://app.codility.com/programmers/lessons/5-prefix_sums/passing_cars/

def solution(a: Array[Int]): Int = {
  a.foldLeft((0, 0)) { (tup, direction) => {
    val (zeroes, pairs) = tup
    if (direction == 0) (zeroes + 1, pairs)
    else {
      val newPairs = pairs + zeroes
      if (newPairs > 1000000000) return -1
      (zeroes, newPairs)
    }
  }}._2
}


assert(solution(Array(0, 1, 0, 1, 1)) == 5)
assert(solution(Array(1, 0, 1, 1)) == 2)
assert(solution(Array(1, 0, 0, 0)) == 0)
assert(solution(Array(1, 0)) == 0)
assert(solution(Array(0, 1)) == 1)

val rand = new scala.util.Random()
def zeroOrOne = if (rand.nextBoolean()) 1 else 0
assert(solution(Array.fill(100000)(zeroOrOne)) == -1)

// result: https://app.codility.com/demo/results/trainingS7Z6FF-RRA/