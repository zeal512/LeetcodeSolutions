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
    private final int mod = 1000000007;
    private long totalSum = 0;
    private long maxProd = 0;    
    
    public int maxProduct(TreeNode root) {
        totalSum = sumOfTree(root);
        currNodeProduct(root);
        return (int) (maxProd % mod);
    }
    private long sumOfTree(TreeNode node){
        if(node == null) return 0;
        return node.val + sumOfTree(node.left) + sumOfTree(node.right);
    }

    private long currNodeProduct(TreeNode node){
        if(node == null) return 0;
        
        long leftSum = currNodeProduct(node.left);
        long rightSum = currNodeProduct(node.right);
        
        long currNodeSum = node.val + leftSum + rightSum;
        long prod = currNodeSum * (totalSum - currNodeSum);
        maxProd = Math.max(maxProd, prod);
        return currNodeSum;
    }
}