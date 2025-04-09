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
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0L, 1);
        return traverseDFS(root, targetSum, 0, prefixSum);
    }
    public int traverseDFS(TreeNode node, long targetSum, long sum, 
                            HashMap<Long, Integer> prefixSum ){
        if(node == null){
            return 0;
        }
        sum +=node.val;
        int count = prefixSum.getOrDefault(sum - targetSum, 0);
        prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) +1);
        
        count +=traverseDFS(node.left, targetSum, sum, prefixSum);
        count +=traverseDFS(node.right, targetSum, sum, prefixSum);
        prefixSum.put(sum, prefixSum.get(sum)-1);
        return count;
    }
}