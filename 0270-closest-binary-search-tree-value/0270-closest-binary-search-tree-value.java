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
/*     public int closestValue(TreeNode root, double target) {
        //double minAbsDiff = Double.MAX_VALUE;
        int smallestVal = Integer.MAX_VALUE;

        while(root != null){
            smallestVal = Math.abs(root.val - target) < Math.abs(smallestVal - target) || 
                            (Math.abs(root.val - target) == Math.abs(smallestVal - target) && 
                            root.val < smallestVal) ? root.val : smallestVal;
            root = target < root.val ? root.left :  root.right;
        }
        
        return smallestVal;
    } */
    public int closestValue(TreeNode root, double target) {
        double[] minAbsDiff = new double[]{Double.MAX_VALUE};
        int[] smallestVal = new int[]{Integer.MAX_VALUE};
        dfs(root, target, minAbsDiff, smallestVal);
        return smallestVal[0];
    }

    public void dfs(TreeNode currNode, double target, double[] minAbsDiff, int[] smallestVal){
        if(currNode == null) return;
        if(target == currNode.val) {
            smallestVal[0] = currNode.val;
            return;
        }
        if(Math.abs(target - currNode.val) <  Math.abs(target - smallestVal[0]) || 
            (Math.abs(target - currNode.val) ==  Math.abs(target - smallestVal[0]) && currNode.val < smallestVal[0])){
            minAbsDiff[0] = Math.abs(target - currNode.val);
            smallestVal[0] = currNode.val;
        }
        if(target < currNode.val) dfs(currNode.left, target, minAbsDiff, smallestVal);
        else dfs(currNode.right, target, minAbsDiff, smallestVal);
    }
}

/* 
if target val is less than currNode val, then we should go left because all nodes on right will be greater than currNode
we need to store the minAbsDiff to compare it with every node. if diff is less than prev diff, update minAbsDiff and the smallestVal answer.
*/