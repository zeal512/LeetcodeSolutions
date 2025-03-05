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
    int minValue;
    long result = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        minValue = root.val;
        dfs(root);
        return result < Long.MAX_VALUE ? (int)result : -1;
    }

    public void dfs(TreeNode root){
        if(root != null){
            if(minValue < root.val && root.val < result){
                result = root.val;
            }
            else if(minValue == root.val){
                dfs(root.left);
                dfs(root.right);
            }
        }
    }
}