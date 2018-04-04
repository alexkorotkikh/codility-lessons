// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/flags/

def solution(a: Array[Int]): Int = {
  def findPeaks(): Seq[Boolean] =
    a.indices.map { i =>
      if (i == 0 || i == a.length - 1) false
      else if (a(i) > a(i - 1) && a(i) > a(i + 1)) true
      else false
    }

  def nextPeaks(peaks: Seq[Boolean]): Seq[Int] = {
    val next = Array.fill(peaks.length)(-1)
    (next.length - 2 to 0 by -1).foreach { i =>
      if (peaks(i)) next(i) = i
      else next(i) = next(i + 1)
    }
    next
  }

  val peaks = findPeaks()
  val next = nextPeaks(peaks)
  (1 to math.sqrt(a.length).ceil.toInt).map { i =>
    var pos = 0
    var num = 0
    while (pos < a.length && num < i && next(pos) != -1) {
      if (next(pos) - (pos - i - 1) >= i) num += 1
      pos = next(pos) + i
    }
    num
  }.max
}

assert(solution(Array(1)) == 0)
assert(solution(Array(1, 5)) == 0)
assert(solution(Array(1, 5, 2)) == 1)
assert(solution(Array(1, 5, 5, 1)) == 0)
assert(solution(Array(1, 5, 4, 1)) == 1)
assert(solution(Array(0, 0, 0, 0, 0, 1, 0, 1, 0, 1)) == 2)
assert(solution(Array(1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2)) == 3)

// result: https://app.codility.com/demo/results/training2QXWHU-ECB/