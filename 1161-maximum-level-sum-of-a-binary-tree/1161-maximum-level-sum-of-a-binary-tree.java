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
    public int maxLevelSum(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        int maxSum = Integer.MIN_VALUE, smallestLevel = Integer.MAX_VALUE;
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int sum =0;
            int size = queue.size();
            level++;
            for(int i=0; i< size; i++){
                TreeNode currNode = queue.poll();
                sum+=currNode.val;
                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }
            if(sum == maxSum) smallestLevel = Math.min(smallestLevel, level);
            else if(sum > maxSum){
                smallestLevel = level;
                maxSum = sum;
            }
        }
        return smallestLevel;
    }
}

/* 
[989,null,10250,98693,-89388,null,null,null,-32127]
        989
          \
         10250
        /     \
    98693   -89388
                 \
                -32127

*/