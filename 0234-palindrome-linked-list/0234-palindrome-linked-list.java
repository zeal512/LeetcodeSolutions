class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true; 
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null, curr = slow;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        ListNode h1 = head, h2 = prev;
        while(h2 != null){
            if(h1.val != h2.val ) return false;
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
        
    }
    
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        ListNode prev =null;
        ListNode front =null;
        while(temp != null){
            front = temp.next;
            temp.next = prev;
			prev = temp;
			temp = front;
        }
        return prev;
    }
}