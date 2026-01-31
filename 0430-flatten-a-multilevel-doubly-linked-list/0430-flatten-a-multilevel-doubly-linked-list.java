/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        dfsHelper(head);
        return head;
    }
    public Node dfsHelper(Node node){
        
        Node temp = node;
        Node prevNode = new Node();
        prevNode.next = temp;

        while (temp != null) {
            if(temp.child != null){
                Node start = temp;
                Node end = temp.next;
                Node left = temp.child;
                Node right = dfsHelper(temp.child);
                
                temp.child = null;
                start.next = left;
                left.prev = start;
                right.next = end;
                
                if(end != null){
                    end.prev = right;
                    temp = right.next;
                }else temp = right;
            }
            else {
                prevNode = temp;
                temp = temp.next;}
        }
        return prevNode;
    }
}