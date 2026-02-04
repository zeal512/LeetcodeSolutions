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
    public ListNode plusOne(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            if (curr.val != 9) {
                prev = curr;
            }
            curr = curr.next;
        }
        if (prev == null) {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            curr = head;
            while (curr != null) {
                curr.val = 0;
                curr = curr.next;
            }
            return newHead;
        }
        prev.val += 1;
        curr = prev.next;
        while (curr != null) {
            curr.val = 0;
            curr = curr.next;
        }
        return head;
    }
}
/* 
1. 9 -> 9 -> 9

2. 1 -> 2 -> 3

3. 1 -> 2 -> 9

4. 0

1. find the node with value not equal to 9, 
because if all the numbers to the right are 9 (1 -> 2 -> 3 -> 9 -> 1), 
then after adding 1  we will have carry and we add carry to the node with value less than 9

so, we need 1 pointer at node 3, and we add 1 to node 3 and it becomes 4 and all nodes after that become 0.

ListNode curr = head;
ListNode prev = null;
while(curr != null){
    if(curr.val != 9){
        prev = curr;
    }
    curr = curr.next;
}
if(prev == null){
    ListNode newHead = new ListNode(1);
    newHead.next = head;
    curr = head;
    while(curr != null){
        curr.val = 0;
        curr = curr.next;
    }
    return newHead;
}
prev.val+=1;
curr = prev.next;
while(curr.next != null){
    curr.val = 0;
    curr = curr.next;
}
return head;

*/