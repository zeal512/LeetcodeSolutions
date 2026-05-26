/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode successor = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        traverse(root, p);
        return successor;
    }

    public void traverse(TreeNode node, TreeNode target){
        if(node == null) return;
        if(target.val < node.val){
            successor = node;
            traverse(node.left, target);
        }
        else traverse(node.right, target);
    }
}