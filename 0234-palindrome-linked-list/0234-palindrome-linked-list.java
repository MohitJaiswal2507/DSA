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
    public static ListNode reverseLinkedList(ListNode head){
        // Edge case
        if (head == null || head.next == null) {
            return head;  
        }

        ListNode newHead = reverseLinkedList(head.next); // 1->2->2(head)->1(head.next/front)->x

        ListNode front = head.next;

        //Linking kardo
        front.next = head;
        head.next = null;

        return newHead;
    }

    public boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return true;  
        }

        // Step 1 => finding the middle 
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode midNode = slow;
        // Step 2 => reversing the 2nd half of the Linked list
        ListNode newHead = reverseLinkedList(slow.next);

        //Step 3 => comparing the 1st half and reversed half Linked list
        ListNode first = head; 
        ListNode second = newHead;

        while(second != null){
            if(first.val != second.val){
                reverseLinkedList(newHead); // After the comparision reversing the LL to its original form
                return false;
            }
            first = first.next;
            second = second.next;
        }

        reverseLinkedList(newHead);// After the comparision reversing the LL to its original form
        return true;
    }
}