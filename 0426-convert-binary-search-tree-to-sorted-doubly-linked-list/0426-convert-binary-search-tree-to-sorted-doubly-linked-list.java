/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node start = null;
    Node end = null;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        start.left = end;
        end.right = start;
        return start;
    }
    public void dfs(Node node){
        if(node != null){
            dfs(node.left);
            if(end != null){
                end.right = node;
                node.left = end;
            }else{
                start = node;
            }
            end = node;
            dfs(node.right);
        }
    }
}