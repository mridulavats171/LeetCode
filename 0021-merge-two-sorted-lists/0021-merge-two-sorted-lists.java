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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode outputList = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                outputList.next = list1;
                list1 = list1.next;  // Move to the next node in list1
            } else {
                outputList.next = list2;
                list2 = list2.next;  // Move to the next node in list2
            }
            outputList = outputList.next;  // Move outputList to the next node
        }
        
        // At this point, either list1 or list2 might still have remaining nodes.
        // We can simply attach the remaining list directly to outputList.
        outputList.next = (list1 != null) ? list1 : list2;

        return dummy.next;  // Return the merged list, starting from the first real node
    }
}
