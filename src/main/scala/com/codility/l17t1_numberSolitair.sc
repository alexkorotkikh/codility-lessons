// https://app.codility.com/programmers/lessons/17-dynamic_programming/number_solitaire/

def solution(a: Array[Int]): Int = {
  val maxs = Array.fill(a.length + 6)(a(0))
  (1 until a.length).foreach { i =>
    maxs(i + 6) = maxs.slice(i, i + 6).max + a(i)
  }
  maxs.last
}

assert(solution(Array(1, -2, 0, 9, -1, -2)) == 8)

// result: https://app.codility.com/demo/results/trainingK4846C-7BS/