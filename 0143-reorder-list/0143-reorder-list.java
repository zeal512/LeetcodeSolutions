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
        if(head.next == null) return;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode first = head, second = reverse(slow.next);
        slow.next = null;
        
        while(first != null && second != null){
            ListNode front = first.next;
            first.next = second;
            first = front;

            ListNode front2 = second.next;
            second.next = first;
            second = front2;
            
        }
    }
    public ListNode reverse(ListNode head){
        ListNode temp = head, prev = null, front = null;
        while(temp != null){
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}