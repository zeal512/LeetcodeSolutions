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
    public ListNode swapNodes(ListNode head, int k) {
        int size = calculateSize(head);
        int source = k-1, destination = size - k;
        ListNode first = head, second = head;
        while(first != null && second != null){
            if(source > 0){
                first = first.next;
                source--;
            }
            if(destination > 0){
                second = second.next;
                destination--;
            }
            if( source == 0 && destination == 0) break;
        }
        int temp = second.val;
        second.val = first.val;
        first.val = temp;
        return head;
    }

    public int calculateSize(ListNode head){
        int size = 0;
        while(head != null){
            size+=1;
            head = head.next;
        }
        return size;
    }
}