// https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/

def solution(s: String): Int = {
  val stack = collection.mutable.Stack[Char]()
  s.foreach {
    case c@('(' | '[' | '{') => stack.push(c)
    case _ if stack.isEmpty => return 0
    case ')' if stack.top != '(' => return 0
    case ']' if stack.top != '[' => return 0
    case '}' if stack.top != '{' => return 0
    case _ => stack.pop()
  }

  if (stack.isEmpty) 1
  else 0
}

assert(solution("") == 1)
assert(solution("(") == 0)
assert(solution("()") == 1)
assert(solution(")(") == 0)
assert(solution("([])") == 1)
assert(solution("()[]") == 1)
assert(solution("([)]") == 0)
assert(solution("{[()()]}") == 1)
assert(solution("([)()]") == 0)

// result: https://app.codility.com/demo/results/training84KDYW-3HC/