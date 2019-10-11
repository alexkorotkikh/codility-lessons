// https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/

def solution(a: Array[Int]): Int =
  a.foldLeft(0)(_ ^ _)

assert(solution(Array(9, 3, 9, 3, 9, 7, 9)) == 7)

// result: https://app.codility.com/demo/results/trainingTPMXTA-DG2/