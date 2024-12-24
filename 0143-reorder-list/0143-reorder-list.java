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
    public void reorderList(ListNode head) {
           if (head == null || head.next == null || head.next.next == null) {
            return; 
        }
        
       // Step 1: Find the middle of the list
        ListNode middle = middleNode(head);
        ListNode secondHalf = reverseList(middle.next); // Step 2: Reverse the second half
        middle.next = null; // Terminate the first half

        // Step 3: Merge the two halves alternately
        ListNode firstHalf = head;
        while (firstHalf != null && secondHalf != null) {
            ListNode temp1 = firstHalf.next;
            ListNode temp2 = secondHalf.next;

            firstHalf.next = secondHalf;
            secondHalf.next = temp1;

            firstHalf = temp1;
            secondHalf = temp2;
        }
       
        
    }
    
     public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
       private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}