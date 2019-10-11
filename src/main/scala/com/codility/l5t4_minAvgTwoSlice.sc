// https://app.codility.com/programmers/lessons/5-prefix_sums/min_avg_two_slice/

def solution(a: Array[Int]): Int = {
  val lastIdx = a.length - 2
  val (idx, avg) =
    (1 until lastIdx).foldLeft((0, (a(0) + a(1)) / 2d)) { (tuple, i) =>
      val (_, minAvg) = tuple
      val next2avg = (a(i) + a(i + 1)) / 2d
      val next3avg = (a(i) + a(i + 1) + a(i + 2)) / 3d
      if (next2avg < minAvg && next2avg < next3avg) (i, next2avg)
      else if (next3avg < minAvg) (i, next3avg)
      else tuple
    }

  val last2avg = (a(lastIdx) + a(lastIdx + 1)) / 2d
  if (last2avg < avg) lastIdx
  else idx
}


assert(solution(Array(1, 2)) == 0)
assert(solution(Array(1, 2, 3)) == 0)
assert(solution(Array(3, 1)) == 0)
assert(solution(Array(3, 1, 2)) == 1)
assert(solution(Array(4, 2, 2, 5, 1, 5, 8)) == 1)
assert(solution(Array(4, 2, 2, 5, 1, 1)) == 4)

// return: https://app.codility.com/demo/results/training36Y7BG-BJB/