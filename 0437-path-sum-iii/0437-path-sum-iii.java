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
    int count =0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        traverseDFS(root, targetSum);
        
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);

        return count;
    }
    public void traverseDFS(TreeNode node, long targetSum){
        if(node == null){
            return;
        }
        if(targetSum == node.val) count++;
        
        traverseDFS(node.left, targetSum - node.val);
        traverseDFS(node.right, targetSum - node.val);

    }
}