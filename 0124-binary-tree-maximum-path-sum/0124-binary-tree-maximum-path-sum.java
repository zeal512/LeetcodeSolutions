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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxPath(root);
        return maxSum;
    }

    public int maxPath(TreeNode node){
        if (node == null) return 0;
        int left = Math.max(0, maxPath(node.left));
        int right = Math.max(0, maxPath(node.right));
        maxSum = Math.max(maxSum, left + right + node.val);
        return Math.max(left,right) + node.val;
    }
}