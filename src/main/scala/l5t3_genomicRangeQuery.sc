// https://app.codility.com/programmers/lessons/5-prefix_sums/genomic_range_query/

def solution(s: String, p: Array[Int], q: Array[Int]): Array[Int] = {
  val factors = s.map(Map('A' -> 1, 'C' -> 2, 'G' -> 3, 'T' -> 4))
  val groupSize = math.floor(math.sqrt(s.length)).toInt
  val groupMins = factors.grouped(groupSize.toInt).map(_.min).toArray
  p.indices.map { i =>
    val minIdx = p(i)
    val maxIdx = q(i) + 1

    if (maxIdx - minIdx <= groupSize) factors.slice(minIdx, maxIdx).min

    else {
      val minGroupMinIdx =
        if (minIdx % groupSize == 0) minIdx
        else minIdx + (groupSize - minIdx % groupSize)
      val maxGroupMaxIdx = maxIdx - (maxIdx % groupSize)
      val minGroupIdx = minGroupMinIdx / groupSize
      val maxGroupIdx = (maxGroupMaxIdx / groupSize) - 1

      val leftMin =
        if (minGroupMinIdx % groupSize == 0) groupMins(minGroupIdx)
        else factors.slice(minIdx, minGroupMinIdx).min

      val rightMin =
        if (maxGroupMaxIdx % groupSize == 0) groupMins(maxGroupIdx)
        else factors.slice(maxGroupMaxIdx, maxIdx).min

      val tempMin = math.min(leftMin, rightMin)
      if (maxGroupIdx > minGroupIdx) math.min(groupMins.slice(minGroupIdx, maxGroupIdx).min, tempMin)
      else tempMin
    }
  }.toArray
}

assert(solution("CAGCCTA", Array(2, 5, 0), Array(4, 5, 6)) sameElements Array(2, 4, 1))

// TODO: implement using sparse table
// result: https://app.codility.com/demo/results/trainingNU8FSZ-72X/