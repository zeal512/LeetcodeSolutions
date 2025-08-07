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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postOrder = new ArrayList<>();
        traverse(root, postOrder);
        return postOrder;
    }
    public static void traverse(TreeNode node, List<Integer> postOrder ){
        if (node == null) {
            return;
        }
        traverse(node.left, postOrder );
        traverse(node.right, postOrder );
        postOrder.add(node.val);
    }
}