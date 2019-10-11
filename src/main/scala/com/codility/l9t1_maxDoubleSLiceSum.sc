// https://app.codility.com/programmers/lessons/9-maximum_slice_problem/max_double_slice_sum/

def solution(a: Array[Int]): Int = {
  val leftSums = Array.fill(a.length)(0)
  val rightSums = Array.fill(a.length)(0)

  1 until a.length - 1 foreach { i =>
    leftSums(i) = math.max(leftSums(i - 1) + a(i), 0)
  }

  a.length - 2 until 0 by -1 foreach { i =>
    rightSums(i) = math.max(rightSums(i + 1) + a(i), 0)
  }

  (1 until a.length - 1).foldLeft(0) { (max, i) =>
    math.max(max, leftSums(i - 1) + rightSums(i + 1))
  }
}

assert(solution(Array(3, 2, 6, -1, 4, 5, -1, 2)) == 17)

// result: https://app.codility.com/demo/results/trainingNM58TX-YGM/