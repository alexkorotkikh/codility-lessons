// https://app.codility.com/programmers/lessons/14-binary_search_algorithm/nailing_planks/

def solution(a: Array[Int], b: Array[Int], c: Array[Int]): Int = {
  def findFirstNail(plankBegin: Int,
                    plankEnd: Int,
                    nails: Array[(Int, Int)],
                    prevRes: Int): Int = {
    var res = -1
    var resPos = -1
    var low = 0
    var high = nails.length - 1
    while (low <= high) {
      val mid = (low + high) / 2
      val midPos = nails(mid)._1
      if (midPos < plankBegin) low = mid + 1
      else if (midPos > plankEnd) high = mid - 1
      else {
        high = mid - 1
        res = nails(mid)._2
        resPos = mid
      }
    }
    if (res == -1) return -1
    else {
      resPos += 1
      while (resPos < nails.length) {
        if (nails(resPos)._1 <= plankEnd) {
          res = math.min(res, nails(resPos)._2)
          resPos += 1
          if (prevRes >= res) return prevRes
        } else {
          resPos = nails.length // break
        }
      }
    }
    math.max(res, prevRes)
  }

  val nails = c.zipWithIndex.sortBy(_._1)
  var res = -1

  a.indices.foreach { i =>
    res = findFirstNail(a(i), b(i), nails, res)
    if (res == -1) return -1
  }
  res + 1
}

assert(solution(Array(1, 4, 5, 8), Array(4, 5, 9, 10), Array(4, 6, 7, 10, 2)) == 4)

// result: https://app.codility.com/demo/results/trainingGSSFG4-RXZ/