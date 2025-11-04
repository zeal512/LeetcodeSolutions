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
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head;
        ListNode start2;
        ListNode start1 = head;
        int sum =0;
        /* Finding middle node of the list */
        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        start2 = reverseHalfLinkedList(slow);
        /* calculagting sum, (firstNode.val + LastNode.val) */
        while (start2 != null) {
            sum = Math.max(sum, start1.val + start2.val);
            start1 = start1.next;
            start2 = start2.next;
        }
        return sum;
    }
    public static ListNode reverseHalfLinkedList(ListNode head){
        ListNode temp = head;
        ListNode back = null;
        ListNode front = null;
        while(temp != null){
            front = temp.next;
            temp.next = back;
            back = temp;
            temp = front;
        }
        return back;
    }
}