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
    int nodeCount =0;
    
    public int averageOfSubtree(TreeNode root) {
        
        if(root == null) return 0;
        calculateSum(root);
        return nodeCount;
    }

    public int[] calculateSum(TreeNode node){
        if (node == null) {
            return new int[]{0,0};
        }
        int[] left= calculateSum(node.left);
        int[] right = calculateSum(node.right);
        int sum = left[0] + right[0] + node.val ;
        int count = left[1] + right[1] + 1;
        if(node.val == (sum/count)) nodeCount++;
        return new int[]{sum,count};
    }
}