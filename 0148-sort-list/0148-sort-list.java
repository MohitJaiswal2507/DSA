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
    public static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next; //one step ahead slow casue if even LL is present then i need a particular no [2,3,4,5]

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode mergeList(ListNode list1 ,ListNode list2){
        ListNode dummyNode = new ListNode(-1, null);

        ListNode temp = dummyNode; // Temp LL for merge list

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next; // Keep traversing
        }

        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummyNode.next;
    }

    public ListNode sortList(ListNode head) {
        
        //Edge case
        if(head == null || head.next == null) return head;

        //Mid element find func using tortoise and hare algo
        ListNode middle = findMiddle(head);

        // dividing right half and left half from mid
        ListNode right = middle.next; 
        middle.next = null;
        ListNode left = head;

        //Sorting the left and right half Nodes
        left = sortList(left);
        right = sortList(right);

        //Merging all the Nodes
        return mergeList(left , right);
    }
}