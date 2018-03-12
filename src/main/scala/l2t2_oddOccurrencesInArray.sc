// https://app.codility.com/programmers/lessons/2-arrays/odd_occurrences_in_array/

def solution(a: Array[Int]): Int =
  a.foldLeft(0)(_ ^ _)