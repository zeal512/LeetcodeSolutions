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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode newHead = temp;
        ListNode prev = temp;
        temp = temp.next;
        while(temp.next != null && temp.val < x){
            prev = temp;
            temp = temp.next;
        }
        ListNode tempPrev = temp;
        temp = temp.next;
        while (temp != null) {
            if(temp.val < x){
                ListNode nextNode = temp.next;
                tempPrev.next = nextNode;
                temp.next = prev.next;
                prev.next = temp;
                prev = prev.next;
                temp = nextNode;
            }
            else{
                tempPrev = temp;
                temp = temp.next;
            }
        }
        return newHead.next;
    }
}
/* 
    1 -> 4 -> 3 -> 2 -> 5 -> 2
              tp   t
    p

approach.
1. find the node that is greater than or equal to x, and keep track of its previous node as well.
2. Continue traversal and if a node val is less than x then link it to prev.next and move the prev pointer ahead. 
 */