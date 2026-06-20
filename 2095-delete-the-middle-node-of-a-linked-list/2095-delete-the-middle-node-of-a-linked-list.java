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
    public ListNode deleteMiddle(ListNode head) {
        //Edge case
        if(head == null || head.next == null) return null;
        //Tortoise and hare modified approach

        ListNode slow = head;
        ListNode fast = head;

        fast = fast.next.next; // we will move this first to get the slow pointer at the (mid-1) Node
       
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // ListNode middle = slow.next;

        //Link change
        slow.next = slow.next.next;
        return head;
    }
}