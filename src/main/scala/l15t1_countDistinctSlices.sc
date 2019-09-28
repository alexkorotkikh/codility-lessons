// https://app.codility.com/programmers/lessons/15-caterpillar_method/count_distinct_slices/

def solution(m: Int, a: Array[Int]) = {
  var res = 0
  var pre = -1
  val hash = Array.fill[Int](m + 1)(-1)
  var i = 0
  while (i < a.length) {
    if (hash(a(i)) > pre) pre = hash(a(i))
    res += i - pre
    hash(a(i)) = i
    if (res > 1000000000) res = 1000000000
    i += 1
  }
  res
}
assert(solution(0, Array(0)) == 1)
assert(solution(3, Array(1, 2, 3)) == 6)
assert(solution(5, Array(3, 4, 5, 5, 2)) == 9)

// result: https://app.codility.com/demo/results/training6DAKTR-8BY/