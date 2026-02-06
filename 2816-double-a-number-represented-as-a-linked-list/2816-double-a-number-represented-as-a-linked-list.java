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
    public ListNode doubleIt(ListNode head) {
        ListNode revHead = reverse(head);
        int carry =0, sum = 0;
        ListNode node = revHead, prev = null;

        while (node != null) {
            sum = node.val + node.val + carry;
            if(sum > 9){
                carry = 1;
                sum = sum%10;
            }
            else carry = 0;
            node.val = sum;
            prev = node;
            node = node.next;
        }
        if(carry == 1){
            prev.next = new ListNode(carry);
        }
        ListNode result = reverse(revHead);
        return result;
    }
    public ListNode reverse(ListNode node){
        ListNode previous = null, currNode = node, nextNode;
        while(currNode != null){
            nextNode = currNode.next;
            currNode.next = previous;
            previous = currNode;
            currNode = nextNode;
        }
        return previous;
    }
}