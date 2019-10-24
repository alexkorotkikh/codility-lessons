class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}

object AddTwoNumbers {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    def add(p: ListNode, q: ListNode, carry: Int): ListNode = {
      val sum = (if (p == null) 0 else p.x) + (if (q == null) 0 else q.x) + carry

      val current = new ListNode(sum % 10)

      if ((p != null && p.next != null) || (q != null && q.next != null) || sum >= 10) {
        current.next = add(
          if (p != null) p.next else null,
          if (q != null) q.next else null,
          sum / 10
        )
      }

      current
    }

    add(l1, l2, 0)
  }
}
