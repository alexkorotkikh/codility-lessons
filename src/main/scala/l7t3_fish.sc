// https://app.codility.com/programmers/lessons/7-stacks_and_queues/fish/

def solution(a: Array[Int], b: Array[Int]): Int = {
  val stack = collection.mutable.Stack[Int]()
  a.indices.foreach { i =>
    val size = a(i)
    val dir = b(i)
    if (dir == 1) stack.push(i)
    else {
      while (stack.nonEmpty && b(stack.top) == 1 && a(stack.top) < size) stack.pop()
      if (stack.isEmpty || b(stack.top) == 0) stack.push(i)
    }
  }

  stack.size
}

assert(solution(Array(1), Array(1)) == 1)
assert(solution(Array(1, 3), Array(1, 0)) == 1)
assert(solution(Array(3, 1), Array(1, 0)) == 1)
assert(solution(Array(4, 3, 2, 1, 5), Array(0, 1, 0, 0, 0)) == 2)
assert(solution(Array(4, 3, 2, 1, 5), Array(1, 1, 1, 1, 1)) == 5)
assert(solution(Array(4, 3, 2, 1, 5), Array(0, 0, 0, 0, 0)) == 5)

// result: https://app.codility.com/demo/results/trainingWDX67V-R7J/