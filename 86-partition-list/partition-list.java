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
    public ListNode partition(ListNode head, int x) {
        ListNode list1 = new ListNode();
        ListNode list2 = new ListNode();
        ListNode node1 = list1;
        ListNode node2 = list2;

        while(head!=null){
            if(head.val<x){
                node1.next = head;
                node1 = node1.next;
            }else{
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
        }
            node1.next = list2.next;
            node2.next = null;

            return list1.next;
        
    }
}