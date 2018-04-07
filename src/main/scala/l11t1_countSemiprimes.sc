// https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_semiprimes/

def solution(n: Int, p: Array[Int], q: Array[Int]): Array[Int] = {
  def makeSieve(n: Int) = {
    val sieve = Array(false, false) ++ Array.fill(n - 1)(true)
    (2 to math.sqrt(n).ceil.toInt).foreach { i =>
      if (sieve(i)) {
        (i * i to n by i).foreach(sieve(_) = false)
      }
    }
    sieve
  }

  def findSemiprimes(sieve: Array[Boolean]) = {
    val semiprimes = Array.fill(sieve.length)(false)
    sieve.indices.foreach { i =>
      (i until sieve.length).foreach { k =>
        if (sieve(i) && sieve(k) && i.toLong * k.toLong < sieve.length) semiprimes(i * k) = true
      }
    }
    semiprimes
  }

  def countSemiprimes(semiprimes: Array[Boolean]): Array[Int] = {
    val semiprimesCount = Array.fill(semiprimes.length)(0)
    (1 until semiprimes.length).foreach { i =>
      semiprimesCount(i) = (if (semiprimes(i)) 1 else 0) + semiprimesCount(i - 1)
    }
    semiprimesCount
  }

  val sieve = makeSieve(n)
  val semiprimes = findSemiprimes(sieve)
  val semiprimesCount = countSemiprimes(semiprimes)

  p.indices.map(i => semiprimesCount(q(i)) - semiprimesCount(p(i) - 1)).toArray
}

assert(solution(5, Array(1), Array(5)) sameElements Array(1))
assert(solution(26, Array(1), Array(26)) sameElements Array(10))
assert(solution(26, Array(16), Array(20)) sameElements Array(0))
assert(solution(26, Array(1, 4, 16), Array(26, 10, 20)) sameElements Array(10, 4, 0))

// result: https://app.codility.com/demo/results/training27SVXF-Z4Q/
// todo: improve performance to 100/100