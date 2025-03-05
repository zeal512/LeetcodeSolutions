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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root, long minValue, long maxValue){
        if(root == null){
            return true;
        }
        else if(root.val <= minValue || root.val >= maxValue){
            return false;
        }
        return isValidBST(root.left,minValue, root.val)
            && isValidBST(root.right, root.val, maxValue);
    }
}