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
    
    public int closestValue(TreeNode root, double target) {
        //double minAbsDiff = Double.MAX_VALUE;
        int smallestVal = Integer.MAX_VALUE;

        while(root != null){
            smallestVal = Math.abs(root.val - target) < Math.abs(smallestVal - target) || 
                            (Math.abs(root.val - target) == Math.abs(smallestVal - target) && 
                            root.val < smallestVal) ? root.val : smallestVal;
            root = target < root.val ? root.left :  root.right;
        }
        
        return smallestVal;
    }
    /* public static void dfs(TreeNode currNode, double target){
        if(currNode == null) return;
        if(target == currNode.val) {
            smallestVal = currNode.val;
            return;
        }
        double diff = Math.abs(target - currNode.val);
        if(diff < minAbsDiff){
            minAbsDiff = Math.min(minAbsDiff, diff);
            smallestVal = currNode.val;
        }
        if(target < currNode.val) dfs(currNode.left, target);
        else dfs(currNode.left, target);
    } */
}

/* 
if target val is less than currNode val, then we should go left because all nodes on right will be greater than currNode
we need to store the minAbsDiff to compare it with every node. if diff is less than prev diff, update minAbsDiff and the smallestVal answer.
*/