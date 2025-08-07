/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        traverse(root, preOrder);
        return preOrder;
    }
    public static void traverse(TreeNode node, List<Integer> preOrder ){
        if (node == null) {
            return;
        }
        preOrder.add(node.val);
        traverse(node.left, preOrder );
        traverse(node.right, preOrder );
    }
}