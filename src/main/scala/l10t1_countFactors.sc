// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/count_factors/

def solution(n: Int): Int = {
  (1 to math.sqrt(n).floor.toInt).foldLeft(0) { (result, i) =>
    if (i * i == n) result + 1
    else if (n % i == 0) result + 2
    else result
  }
}
assert(solution(1) == 1)
assert(solution(2) == 2)
assert(solution(3) == 2)
assert(solution(24) == 8)
assert(solution(2147483646) == 192)
assert(solution(2147483647) == 2)

// result: https://app.codility.com/demo/results/trainingD7SUDT-6J4/