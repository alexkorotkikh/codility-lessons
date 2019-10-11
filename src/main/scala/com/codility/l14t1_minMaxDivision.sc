// https://app.codility.com/programmers/lessons/14-binary_search_algorithm/min_max_division/
def countBlocks(a: Array[Int], max: Int): Int = {
  a.slice(1, a.length)
    .foldLeft((1, a(0))) {
      case ((blocks, sum), elem) =>
        if (sum + elem > max) (blocks + 1, elem)
        else (blocks, sum + elem)
    }
    ._1
}

def solution(k: Int, m: Int, a: Array[Int]): Int = {
    var lowest = a.max
    var highest = a.sum
    var result = 0

    if (k >= a.length) lowest
    else if (k == 1) highest
    else {
      while (lowest <= highest) {
        val mid = (lowest + highest) / 2
        if (countBlocks(a, mid) <= k) {
          highest = mid - 1
          result = mid
        } else {
          lowest = mid + 1
        }
      }
      result
    }
  }

assert(solution(3, 5, Array(2, 1, 5, 1, 2, 2, 2)) == 6)

// result: https://app.codility.com/demo/results/trainingB4DPW3-UB9/
