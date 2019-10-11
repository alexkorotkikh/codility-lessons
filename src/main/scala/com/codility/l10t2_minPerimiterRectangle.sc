// https://app.codility.com/programmers/lessons/10-prime_and_composite_numbers/min_perimeter_rectangle/

// space (O(sqrt(N))
def solution(n: Int): Int = {
  (1 to math.sqrt(n).floor.toInt)
    .filter(i => n % i == 0)
    .map(i => 2 * (i + n / i))
    .min
}

assert(solution(1) == 4)
assert(solution(2) == 6)
assert(solution(30) == 22)
assert(solution(1000000000) == 126500)

// result: https://app.codility.com/demo/results/trainingJAX7BG-QBM/


// space O(1)
def solution2(n: Int): Int = {
  (1 to math.sqrt(n).floor.toInt).foldLeft(Int.MaxValue) { (min, i) =>
    if (n % i == 0 && 2 * (i + n / i) < min) 2 * (i + n / i)
    else min
  }
}

assert(solution2(1) == 4)
assert(solution2(2) == 6)
assert(solution2(30) == 22)
assert(solution2(1000000000) == 126500)

// result: https://app.codility.com/demo/results/trainingTMDUM5-S6V/