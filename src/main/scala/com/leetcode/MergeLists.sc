class ListNode(var _x: Int = 0) {
  var next: ListNode = _
  var x: Int = _x
}

object MergeLists {
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
    val preHead = new ListNode(Int.MinValue)
    var last = preHead
    var p = l1
    var q = l2

    while (p != null && q != null) {
      if (p.x > q.x) {
        last.next = q
        q = q.next
      }
      else {
        last.next = p
        p = p.next
      }
      last = last.next
    }

    if (p == null) last.next = q
    else last.next = p

    preHead.next
  }
}