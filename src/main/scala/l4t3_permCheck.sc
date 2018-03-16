// https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/

def solution(a: Array[Int]): Int = {
  val set = scala.collection.mutable.Set[Int]()
  var arraySum = 0
  val n = a.length
  val apSum = (n * n + n) / 2

  a.foreach { e =>
    arraySum += e
    set.add(e)
  }

  if (set.size == a.length && arraySum == apSum) 1
  else 0
}


assert(solution(Array(3, 1, 4, 2)) == 1)
assert(solution(Array(3, 1, 4)) == 0)
assert(solution(Array(1)) == 1)
assert(solution(Array(2)) == 0)
assert(solution(Array(1, 4, 1)) == 0)

// result: https://app.codility.com/demo/results/trainingN7N437-RSZ/