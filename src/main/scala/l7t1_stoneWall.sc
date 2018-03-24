// https://app.codility.com/programmers/lessons/7-stacks_and_queues/stone_wall/

def solution(h: Array[Int]): Int = {
  val stack = collection.mutable.Stack[Int]()
  h.foldLeft((0, 0)) { (tuple, height) =>
    val (blocksCount, currentHeight) = tuple
    if (currentHeight == height) tuple
    else if (currentHeight < height) {
      stack.push(height - currentHeight)
      (blocksCount + 1, height)
    } else {
      var tempHeight = currentHeight
      while (tempHeight > height) tempHeight -= stack.pop()
      if (tempHeight == height) (blocksCount, height)
      else {
        stack.push(height - tempHeight)
        (blocksCount + 1, height)
      }
    }
  }._1
}

assert(solution(Array(1)) == 1)
assert(solution(Array(1, 1)) == 1)
assert(solution(Array(1, 2, 1)) == 2)
assert(solution(Array(1, 1, 2)) == 2)
assert(solution(Array(8, 8, 5, 7, 9, 8, 7, 4, 8)) == 7)

// result: https://app.codility.com/demo/results/training2HQW89-345/