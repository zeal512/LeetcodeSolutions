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
    public int sumNumbers(TreeNode root) {
        /* int depth = findDepth(root); */
        return calculateSum(root, 0);

    }

    public int calculateSum(TreeNode node, int sum){
        if(node == null) return 0;
        sum = sum * 10 + node.val;
        if(node.left == null && node.right == null) return sum;
        
        return calculateSum(node.left, sum) + calculateSum(node.right, sum);
    }

    /* public int findDepth(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftDepth = findDepth(node.left);
        int rightDepth = findDepth(node.right);
        return 1+Math.max(leftDepth, rightDepth);
    } */
}