// https://app.codility.com/programmers/lessons/1-iterations/binary_gap/

def solution(n: Int) = {
  """(?=(1(0+)1))""".r
    .findAllMatchIn(n.toBinaryString)
    .map(_.group(1))
    .toList
    .foldLeft(0)(_ max _.length - 2)
}

assert(solution(123123) == 5)
assert(solution(328) == 2)
assert(solution(15) == 0)

// result: https://app.codility.com/demo/results/trainingTD8U5P-2NR/