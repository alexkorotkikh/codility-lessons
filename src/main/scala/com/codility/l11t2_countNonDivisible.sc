// https://app.codility.com/programmers/lessons/11-sieve_of_eratosthenes/count_non_divisible/

def solution(a: Array[Int]): Array[Int] = {
  val frequency = collection.mutable.Map[Int, Int]()
  val divisors = collection.mutable.Map[Int, collection.mutable.Set[Int]]()
  a.foreach { n =>
    frequency.put(n, frequency.getOrElse(n, 0) + 1)
    divisors.put(n, collection.mutable.Set(1, n))
  }

  val max = a.max

  (2 to max).foreach { divisor =>
    (divisor to max by divisor).foreach { candidate =>
      if (divisors.contains(candidate) && !divisors(candidate).contains(divisor)) {
        divisors(candidate).add(divisor)
        divisors(candidate).add(candidate / divisor)
      }
    }
  }

  a.map { n =>
    a.length - divisors(n).toArray.map(div => frequency.getOrElse(div, 0)).sum
  }
}

assert(solution(Array(1)) sameElements Array(0))
assert(solution(Array(1, 2)) sameElements Array(1, 0))
assert(solution(Array(1, 2, 3)) sameElements Array(2, 1, 1))
assert(solution(Array(1, 3, 3)) sameElements Array(2, 0, 0))
assert(solution(Array(3, 1, 2, 3, 6)) sameElements Array(2, 4, 3, 2, 0))

// result: https://app.codility.com/demo/results/trainingGE58Z5-54N/