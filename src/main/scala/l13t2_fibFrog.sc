// https://app.codility.com/programmers/lessons/13-fibonacci_numbers/fib_frog/
  def solution(a: Array[Int]): Int = {
    val n = a.length
    val inf = 1000000

    val fibs = Array(1, 2) ++ Array.ofDim[Int](25)
    (2 until 27).foreach(i => fibs(i) = fibs(i - 1) + fibs(i - 2))

    val moves = Array.fill(n + 1)(inf)
    fibs.indices.foreach { i =>
      if (fibs(i) - 1 < n && a(fibs(i) - 1) == 1) {
        moves(fibs(i) - 1) = 1
      }
      if (fibs(i) - 1 == n) {
        moves(n) = 1
      }
    }

    val arr = a ++ Array(1)
    arr.indices.foreach { i =>
      if (arr(i) == 1)
        for (j <- fibs.indices) {
          if (i - fibs(j) >= 0 && moves(i - fibs(j)) != inf
              && moves(i) > moves(i - fibs(j)) + 1) {
            moves(i) = moves(i - fibs(j)) + 1
          }
        }
    }

    if (moves(n) == inf) -1
    else moves(n)
  }

solution(Array(0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0))

// result: https://app.codility.com/demo/results/trainingNKZSGA-US3/