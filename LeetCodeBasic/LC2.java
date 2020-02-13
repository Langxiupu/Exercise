/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        int carry = 0;
        ListNode head = null;
        ListNode currentNode = null;

        while(l1 != null || l2 != null)
        {
            int whichCase = l1 == null ? 0 : 1;
            whichCase += l2 == null ? 0 : 1;
            int sum = 0;
            ListNode newNode = null;

            switch(whichCase)
            {
                case 1:
                    if(l1 == null)
                    {
                        sum = l2.val + carry;
                        carry = sum / 10;
                        newNode = new ListNode(sum % 10);
                        l2 = l2.next;
                    }
                    else
                    {
                        sum = l1.val + carry;
                        carry = sum / 10;
                        newNode = new ListNode(sum % 10);
                        l1 = l1.next;
                    }
                    break;
                case 2:
                    sum = l1.val + l2.val + carry;
                    carry = sum / 10;
                    newNode = new ListNode(sum % 10);
                    l1 = l1.next;
                    l2 = l2.next;
                    break;
            }
            if(head == null)
            {
                head = newNode;
                currentNode = head;
            }
            else
            {
                currentNode.next = newNode;
                currentNode = currentNode.next;
            }
        }
        if(carry != 0)
        {
            currentNode.next = new ListNode(carry);
        }
        return head;
    }
}
