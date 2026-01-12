/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        Node original = head;
        while (original != null) {
            Node copy = new Node(original.val);
            map.put(original, copy);
            original = original.next;
        }
        original = head;
        while (original != null) {
            map.get(original).next = map.get(original.next);
            map.get(original).random = map.get(original.random);
            original = original.next;
        }
        return map.get(head);
    }
}