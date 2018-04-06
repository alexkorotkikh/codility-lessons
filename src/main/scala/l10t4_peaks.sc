// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/peaks/

def solution(a: Array[Int]): Int = {
  val peaksIdx = (1 until a.length - 1).filter(i => a(i) > a(i - 1) && a(i) > a(i + 1))
  (1 to a.length).foldLeft(0) { (acc, s) =>
    if (a.length % s != 0) acc
    else {
      val blockCount = a.length / s
      val peaksInBlocks = peaksIdx.foldLeft(0) { (found, peakIdx) =>
        if (peakIdx / s == found) found + 1
        else found
      }
      if (blockCount == peaksInBlocks) return blockCount
      else acc
    }
  }
}

assert(solution(Array(1)) == 0)
assert(solution(Array(1, 2)) == 0)
assert(solution(Array(1, 2, 3)) == 0)
assert(solution(Array(1, 2, 1)) == 1)
assert(solution(Array(1, 2, 1, 2, 1)) == 1)
assert(solution(Array(1, 2, 1, 1, 2, 1)) == 2)
assert(solution(Array(1, 2, 3, 1, 2, 1)) == 2)
assert(solution(Array(1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2)) == 3)

// result: https://app.codility.com/demo/results/trainingMF5GMQ-YJX/