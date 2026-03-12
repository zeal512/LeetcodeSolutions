
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        
        if(head == null) return new ListNode[k];

        ListNode temp = head;
        int listSize = 0;
        while (temp != null) {
            listSize+=1;
            temp = temp.next;
        }

        
        temp = head;
        ListNode[] result = new ListNode[k];
        int remainder = listSize%k, subListSize = listSize/k;
        
        for(int i=0; i< k; i++){
            if(temp == null){
                result[i] = null;
                continue;
            }
            result[i] = temp;
            int partSize = subListSize + (remainder > 0? 1 : 0);
            remainder-=1;
            for(int j = 1; j< partSize; j++){
                temp = temp.next;
            }
            ListNode newList = temp.next;
            temp.next = null;
            temp = newList;
        }
        return result;
    }
}