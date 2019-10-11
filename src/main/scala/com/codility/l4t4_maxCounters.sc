// https://app.codility.com/programmers/lessons/4-counting_elements/max_counters/

def solution(n: Int, a: Array[Int]): Array[Int] = {
  val counters = Array.fill(n)(0)
  var max, min = 0

  a.foreach { op =>
    if (op <= n) {
      val i = op - 1
      if (counters(i) < min) counters(i) = min
      counters(i) += 1
      if (counters(i) > max) max = counters(i)
    } else {
      min = max
    }
  }

  counters.indices.foreach { pos =>
    if (counters(pos) < min) counters(pos) = min
  }

  counters
}

assert(solution(5, Array(3, 4, 4, 6, 1, 4, 4)) sameElements Array(3, 2, 2, 4, 2))

// result: https://app.codility.com/demo/results/trainingTGTQS7-CUW/