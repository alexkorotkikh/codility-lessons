// https://app.codility.com/programmers/lessons/8-leader/equi_leader/

def solution(a: Array[Int]): Int = {
  def _leader(a: Array[Int]): (Int, Int) = {
    val (_, idx) =
      a.indices.foldLeft((0, 0)) { (tuple, i) =>
        val (counter, candidate) = tuple
        if (a(i) == a(candidate)) (counter + 1, candidate)
        else if (counter == 0) (1, i)
        else (counter - 1, candidate)
      }

    val leader = a(idx)
    val count = a.count(_ == leader)
    (leader, count)
  }

  val (leader, leaderCount) = _leader(a)
  a.indices.foldLeft((0, 0)) { (acc, i) =>
    var (equiCount, leftLeaderCount) = acc
    if (a(i) == leader) leftLeaderCount += 1
    val rightLeaderCount = leaderCount - leftLeaderCount
    if (leftLeaderCount > (i + 1) / 2 && rightLeaderCount > (a.length - i - 1) / 2)
      equiCount += 1

    (equiCount, leftLeaderCount)
  }._1
}

assert(solution(Array(4, 3, 4, 4, 4, 2)) == 2)

// result: https://app.codility.com/demo/results/trainingC48S65-YRZ/