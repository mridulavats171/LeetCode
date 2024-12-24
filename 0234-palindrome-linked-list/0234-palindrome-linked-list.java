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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true; // A list with 0 or 1 node is always a palindrome
        } 
        if(head.next.next == null){
            if(head.val != head.next.val){
                return false;
            } else{
                return true;
            }
        }

        // Step 1: Find the middle of the list
        ListNode middle = middleNode(head);

        // Step 2: Reverse the second half of the list
        ListNode secondHalf = reverseList(middle);

        // Step 3: Compare the two halves
        ListNode firstHalf = head;
        ListNode secondHalfIter = secondHalf;

        while (secondHalfIter != null) {
            if (firstHalf.val != secondHalfIter.val) {
                return false; // Return false if any value does not match
            }
            firstHalf = firstHalf.next;
            secondHalfIter = secondHalfIter.next;
        }

        // Optional: Restore the second half of the list to its original state
        reverseList(secondHalf);

        return true;
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        // Find the middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // This will be the starting node of the second half
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
