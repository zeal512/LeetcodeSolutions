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
    public static int helper(TreeNode node, int max, int counter) {
        if (node == null)
            return counter;

        if (node.val >= max) {
            counter+=1;
            max = Math.max(node.val, max);
            System.out.println("for node "+node.val + " counter is "+counter);
        }
        int leftCounter = helper(node.left, max, counter);
        int rightCounter = helper(node.right, max, leftCounter);
        return rightCounter;
    }

    public int goodNodes(TreeNode root) {
        int max = root.val;
        return helper(root, max, 0);
    }
}