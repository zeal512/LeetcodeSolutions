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
    int minMoves;
    public int distributeCoins(TreeNode root) {
        minMoves = 0;
        traverse(root);
        return minMoves;
    }
    public int traverse(TreeNode node){
        if(node == null) return 0;
        int leftReturn = traverse(node.left);
        int rightReturn = traverse(node.right);
        minMoves += Math.abs(leftReturn) + Math.abs(rightReturn);
        return (node.val - 1) + leftReturn + rightReturn;
    }
}