object LetterCombinations {
  val map = Map(
    '2' -> "abc",
    '3' -> "def",
    '4' -> "ghi",
    '5' -> "jkl",
    '6' -> "mno",
    '7' -> "pqrs",
    '8' -> "tuv",
    '9' -> "wxyz",
  )

  def letterCombinations(digits: String): List[String] = {
    def m(comb: String, rest: String, res: List[String]): List[String] = {
      rest match {
        case "" if comb.isEmpty => res
        case "" => res :+ comb
        case _ =>
          val d = rest(0)
          val ls = map(d)
          ls.toList.flatMap[String](l => m(comb + l, rest.substring(1), res))
      }
    }

    m("", digits, List())
  }
}


assert(LetterCombinations.letterCombinations("23") sameElements Array("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))