/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;

        while (list1 != null || list2 != null || carry != 0) {
            int d1 = 0;
            int d2 = 0;
            if (list1 != null) {
                d1 = list1.val;
                list1 = list1.next;
            }

            if (list2 != null) {
                d2 = list2.val;
                list2 = list2.next;
            }

            int sum = d1 + d2 + carry;
            int digit = sum % 10;

            carry = sum / 10;
            temp.next = new ListNode(digit);
            temp = temp.next;
        }

        return dummy.next;

    }
}