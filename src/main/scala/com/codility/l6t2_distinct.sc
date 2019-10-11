// https://app.codility.com/programmers/lessons/6-sorting/distinct/

// O(N)
def solution(a: Array[Int]): Int =
  a.toSet.size

// result: https://app.codility.com/demo/results/trainingDKFGD3-RGR/

// O(N*logN)
def solution2(a: Array[Int]): Int =
  a.sorted.foldLeft((0, -1)) {
    case ((i, num), newNum) if num != newNum => (i + 1, newNum)
    case (acc, _) => acc
  }._1

// result: https://app.codility.com/demo/results/trainingXGT887-2AA/