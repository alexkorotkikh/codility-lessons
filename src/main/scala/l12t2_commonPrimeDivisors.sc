// https://app.codility.com/programmers/lessons/12-euclidean_algorithm/common_prime_divisors/
def solution(a: Array[Int], b: Array[Int]): Int = {
  @scala.annotation.tailrec
  def gcd(x: Int, y: Int): Int =
    if (x % y == 0) y
    else gcd(y, x % y)

  @scala.annotation.tailrec
  def removeCommonPrimeDivisors(x: Int, y: Int): Int = {
    val v = gcd(x, y)
    if (v == 1) x
    else removeCommonPrimeDivisors(x / v, y)
  }

  a.zip(b).count {
    case (x, y) =>
      val v = gcd(x, y)
      removeCommonPrimeDivisors(x, v) == 1 &&
      removeCommonPrimeDivisors(y, v) == 1
  }
}

assert(solution(Array(15, 10, 3, 54, 100), Array(75, 30, 5, 36, 10)) == 3)

// result: https://app.codility.com/demo/results/training3EXSNS-G83/