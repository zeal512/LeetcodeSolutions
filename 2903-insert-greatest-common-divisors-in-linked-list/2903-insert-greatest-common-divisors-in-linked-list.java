/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head.next == null) return head;
        ListNode first = head, second = head.next;
        while(second != null){
            int gcd = calculateGCD(first.val, second.val);
            ListNode temp = new ListNode(gcd);
            temp.next = second;
            first.next = temp;
            first = second;
            second = second.next;
        }
        return head;
    }

    public static int calculateGCD(int num1, int num2) {
        /* int gcd = Math.min(num1, num2);
        while (gcd > 1) {
            if (num1 % gcd == 0 && num2 % gcd == 0) {
                return gcd;
            }
            gcd--;
        }
        return 1; */
        if(num2 == 0) return num1;
        return calculateGCD(num2, num1%num2);
    }
}