// https://app.codility.com/programmers/lessons/15-caterpillar_method/abs_distinct/

def solution(a: Array[Int]): Int = {
  val distinct = collection.mutable.Set[Int]()
  a.foreach(i => distinct.add(math.abs(i)))
  distinct.size
}

assert(solution(Array(-5, -3, -1, 0, 3, 6)) == 5)

// result: https://app.codility.com/demo/results/trainingMGCYZG-6JU/