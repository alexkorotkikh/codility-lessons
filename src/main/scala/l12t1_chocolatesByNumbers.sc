// https://app.codility.com/programmers/lessons/12-euclidean_algorithm/chocolates_by_numbers/

def solution(n: Int, m: Int): Int = {
  def gcd(a: Int, b: Int): Int =
    if (a % b == 0) b
    else gcd(b, a % b)

  ((n.toLong * m / gcd(n, m)) / m).toInt
}

assert(solution(10, 4) == 5)

// result: https://app.codility.com/demo/results/trainingHEF39R-5TC/