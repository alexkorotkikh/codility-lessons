// https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/

def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
  def getMid(start: Int, end: Int) = start + (end - start) / 2

  def preprocess(input: Array[Int]): Array[Int] = {
    def _preprocess(input: Array[Int], segTree: Array[Int], start: Int, end: Int, idx: Int): Int = {
      if (start == end) {
        segTree(idx) = input(start)
        input(start)
      } else {
        val mid = getMid(start, end)
        segTree(idx) = math.min(
          _preprocess(input, segTree, start, mid, idx * 2 + 1),
          _preprocess(input, segTree, mid + 1, end, idx * 2 + 2)
        )
        segTree(idx)
      }
    }

    val treeHeight = Math.ceil(Math.log(input.length) / Math.log(2))
    val treeSize = 2 * Math.pow(2, treeHeight).toInt - 1
    val segTree = new Array[Int](treeSize)

    _preprocess(input, segTree, 0, input.length - 1, 0)

    segTree
  }

  def query(segTree: Array[Int], n: Int, p: Int, q: Int): Int = {
    def _query(segStart: Int, segEnd: Int, q: Int, p: Int, idx: Int): Int = {
      if (q <= segStart && p >= segEnd) segTree(idx)
      else if (segEnd < q || segStart > p) Int.MaxValue
      else {
        val mid = getMid(segStart, segEnd)
        math.min(_query(segStart, mid, q, p, 2 * idx + 1), _query(mid + 1, segEnd, q, p, 2 * idx + 2))
      }
    }

    _query(0, n - 1, p, q, 0)
  }

  val input = s.map(Map('A' -> 1, 'C' -> 2, 'G' -> 3, 'T' -> 4)).toArray
  val segmentTree = preprocess(input)
  p.indices.map(i => query(segmentTree, input.length, p(i), q(i))).toArray
}

solution("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6))
assert(solution("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6)) sameElements Array(2, 4, 1))

// result: https://app.codility.com/demo/results/trainingZ393VN-NFQ/