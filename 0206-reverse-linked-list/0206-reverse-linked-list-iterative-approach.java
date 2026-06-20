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
    public ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null; 
        
        while(temp != null){
            ListNode front = temp.next; //saving the current location
            temp.next = prev; // changing the links
            prev = temp;
            temp = front;
        }
        
        return prev;
    }
}