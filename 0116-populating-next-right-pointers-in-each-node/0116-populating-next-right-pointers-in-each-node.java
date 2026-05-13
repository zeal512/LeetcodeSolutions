/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    /* public Node connect(Node root) {
        if(root == null) return root;
        Queue<Node> queue = new LinkedList<>();
        Node newRoot = root;
        newRoot.next = null;
        queue.offer(newRoot);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i< size; i++){
                Node currNode = queue.poll();
                if(i < size - 1) currNode.next = queue.peek();
                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }
        }
        return newRoot;
    } */
    /* 
        The above solution is using Queue (Level order traversal), 
        we link the currentNode.next to next node in queue (queue.peek())
        but the problem with this approach is it uses O(n) Time and Space.
    */

    /* 
        If we use the previously generated connections using next pointer, we can traverse the tree 
        in level order and establish connection. 
        This approach would take O(n) time and O(1) space.
    */

    public Node connect(Node root){
        if(root == null) return null;
        Node leftMostNode = root;
        while (leftMostNode.left != null) {
            Node currNode = leftMostNode;
            while (currNode != null) {
                currNode.left.next = currNode.right;
                if(currNode.next != null){
                    currNode.right.next = currNode.next.left;
                }
                currNode = currNode.next;
            }
            leftMostNode = leftMostNode.left;
        }
        return root;
    }
}