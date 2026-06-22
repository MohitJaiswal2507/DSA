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
    //Helper function for finding NewLastNode that temp - k
    public static ListNode findNewLastNode(ListNode temp , int k){
        int cnt = 1;
        while(temp != null){
            if(k == cnt) return temp;

            cnt++;
            temp = temp.next;
        }
        return temp;
    }
    
    public ListNode rotateRight(ListNode head, int k) {
        //Edge case
        if(head == null || head.next == null) return head; 

        ListNode tail = head; 
        int len = 1;

        while(tail.next != null){
            tail = tail.next;
            len++;
        } 

        //multiple of len -> suppose k=5 for [1,2,3,4,5] then after 5 turns it will be same 
        if(k % len == 0) return head; 

        k = k % len;

        //moving the tail to the head
        tail.next = head;
        ListNode NewLastnode = findNewLastNode(head , (len-k));

        head = NewLastnode.next;
        NewLastnode.next = null;

        return head;
    }
}