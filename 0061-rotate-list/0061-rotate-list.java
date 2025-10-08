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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        
        int lengthOfList = lengthOfList(head);
        int counter = k % lengthOfList; 

        ListNode tail = head;
        while (counter > 0 ) {
            tail = tail.next;
            counter-=1;
        }        
        ListNode newTail = head;
        while (tail.next != null) {
            tail = tail.next;
            newTail = newTail.next;
        }
        tail.next = head;
        head = newTail.next;
        newTail.next = null;
        return head;
    }
    public static int lengthOfList(ListNode head){
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len+=1;
            temp = temp.next;
        }
        return len;
    }
}