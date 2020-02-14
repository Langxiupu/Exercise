public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode cursor = head.next;
        while(head != null && cursor != null && cursor.next != null)
        {
            if(head == cursor)
                return true;
            head = head.next;
            cursor = cursor.next.next;
        }
        return false;
    }
}

class ListNode
{
    int val;
    ListNode next;

    ListNode(int x)
    {
        val = x;
        next = null;
    }
}
