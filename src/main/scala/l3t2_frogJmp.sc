// https://app.codility.com/programmers/lessons/3-time_complexity/frog_jmp/

def solution(x: Int, y: Int, d: Int): Int =
  math.ceil((y - x) / d.toDouble).toInt

assert(solution(10, 85, 30) == 3)
assert(solution(10, 10, 30) == 0)
assert(solution(1, 1000000000, 1) == 999999999)

// result: https://app.codility.com/demo/results/trainingMAMGNB-MUV/