// https://app.codility.com/programmers/lessons/8-leader/dominator/

def solution(a: Array[Int]): Int = {
    val (_, idx) =
      a.indices.foldLeft((0, 0)) { (tuple, i) =>
        val (counter, candidate) = tuple
        if (a(i) == a(candidate)) (counter + 1, candidate)
        else if (counter == 0) (1, i)
        else (counter - 1, candidate)
      }

    if (a.count(_ == a(idx)) > a.length / 2) idx
    else -1
}

assert(solution(Array(3, 4, 3, 2, 3, -1, 3, 3)) == 0)
assert(solution(Array(2, 1, 1, 1, 3)) == 2)

// result: https://app.codility.com/demo/results/trainingKB3MHM-BZW/