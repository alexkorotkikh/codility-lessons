//  https://app.codility.com/programmers/lessons/6-sorting/number_of_disc_intersections/

def solution(a: Array[Int]): Int = {
  val edges = a.indices.flatMap { i =>
    Array((i - a(i).toLong, true), (i + a(i).toLong, false))
  }
  val sorted = edges.sortBy(e => (e._1, !e._2))
  sorted.foldLeft(0, 0) { (tuple, next) =>
    val (count, currentCircles) = tuple
    val (_, isCircleStart) = next
    if (count > 10000000) return -1
    else if (isCircleStart) (count + currentCircles, currentCircles + 1)
    else (count, currentCircles - 1)
  }._1
}

assert(solution(Array(1, 5, 2, 1, 4, 0)) == 11)
assert(solution(Array()) == 0)
assert(solution(Array(0, 1)) == 1)
assert(solution(Array(0, 0)) == 0)
assert(solution(Array(1, 0, 0, 3)) == 4)
assert(solution(Array(1, 2147483647, 0)) == 2)

val r = new util.Random()
assert(solution(Array.fill(10000)(r.nextInt(Int.MaxValue))) == -1)

// result: https://app.codility.com/demo/results/trainingYRDEJ5-U29/