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
    public int distance;
    public int traverse(TreeNode root){
        if(root == null)return 0;
        int leftDistance= traverse(root.left);
        int rightDistance= traverse(root.right);
        distance = Math.max(distance, leftDistance+rightDistance);
        return Math.max(leftDistance, rightDistance) +1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        traverse(root);
        return distance;
    }
}