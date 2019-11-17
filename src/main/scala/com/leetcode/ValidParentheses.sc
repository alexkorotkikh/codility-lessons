import scala.collection.mutable

object ValidParentheses {
  def isValid(s: String): Boolean = {
    @annotation.tailrec
    def _isValid(str: String, stack: List[Char]): Boolean =
      str.headOption match {
        case Some('(') => _isValid(str.tail, '(' +: stack)
        case Some('[') => _isValid(str.tail, '[' +: stack)
        case Some('{') => _isValid(str.tail, '{' +: stack)
        case Some(')') => if (stack.headOption.contains('(')) _isValid(str.tail, stack.tail) else false
        case Some(']') => if (stack.headOption.contains('[')) _isValid(str.tail, stack.tail) else false
        case Some('}') => if (stack.headOption.contains('{')) _isValid(str.tail, stack.tail) else false
        case _ => stack.isEmpty
      }

    _isValid(s, List())
  }
}