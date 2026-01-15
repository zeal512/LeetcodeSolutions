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
/*     public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        
        while(set.contains(head.val)) head = head.next;
        ListNode temp = head.next;
        ListNode prev = head;
        
        while (temp != null) {
            if(set.contains(temp.val)) prev.next = prev.next.next;
            else prev = prev.next;
            temp = temp.next;
        }
        return head;
    } */
        public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        ListNode prev = dummy;
        
        while (curr != null) {
            if(set.contains(curr.val)) prev.next = prev.next.next;
            else prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }
}