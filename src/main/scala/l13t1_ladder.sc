// https://app.codility.com/programmers/lessons/13-fibonacci_numbers/ladder/
def solution(a: Array[Int], b: Array[Int]): Array[Int] = {
  val limit = a.max
  val modLimit = (1 << b.max) - 1

  val fib = Array(0, 1) ++ Array.ofDim[Int](limit)
  (2 until limit + 2).foreach { i =>
    fib(i) = (fib(i - 1) + fib(i - 2)) & modLimit
  }

  a.indices.map { i =>
    fib(a(i) + 1) & ((1 << b(i)) - 1)
  }.toArray
}

assert(solution(Array(4, 4, 5, 5, 1), Array(3, 2, 4, 3, 1)) sameElements Array(5, 1, 8, 0, 1))
assert(solution(Array(50000), Array(30)) sameElements Array(890883426))

// result: https://app.codility.com/demo/results/trainingMSEZ5G-D83/