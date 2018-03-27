// https://app.codility.com/programmers/lessons/7-stacks_and_queues/nesting/

def solution(s: String): Int = {
  val counter = s.foldLeft(0) { (result, char) =>
    if (char == '(') result + 1
    else if (char == ')' && result - 1 < 0) return 0
    else result - 1
  }

  if (counter == 0) 1
  else 0
}

assert(solution("") == 1)
assert(solution("(") == 0)
assert(solution("()") == 1)
assert(solution(")(") == 0)
assert(solution("(())") == 1)
assert(solution("()()") == 1)
assert(solution("())") == 0)
assert(solution("(()(())())") == 1)
assert(solution("()())") == 0)

// result: https://app.codility.com/demo/results/trainingGZ5NG9-RTB/