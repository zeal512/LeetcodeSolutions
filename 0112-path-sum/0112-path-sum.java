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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            return targetSum - root.val == 0;
        }
        targetSum -=root.val;
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    /* public static boolean check(TreeNode node, int targetSum){
        if(node == null || targetSum == 0){
            if(node.left == null && node.right == null){
                if(targetSum ==0) return true;
                else if(targetSum > 0) return false;
            }
            return false;
        }
        if((node.left != null || node.right != null) && targetSum == 0) return false;
        //return false;
        //if(node == null && targetSum > 0) return false;
        targetSum -=node.val;
        boolean l = check(node.left, targetSum);
        boolean r = check(node.right, targetSum);
        return check(node.left, targetSum) || check(node.right, targetSum);
    } */
}