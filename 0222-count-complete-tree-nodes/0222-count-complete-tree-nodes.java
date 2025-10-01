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
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int left_height = claculate_left_height(root);
        int right_height = calculate_right_height(root);
        if (left_height == right_height) return ((1<<(left_height))-1);
        else return countNodes(root.left) + countNodes(root.right) +1;
    }
    public static int claculate_left_height(TreeNode node){
        int height =0;
        while(node!= null){
            height++;
            node = node.left;
        }
        return height;
    }
    public static int calculate_right_height(TreeNode node){
        int height =0;
        while(node!= null){
            height++;
            node = node.right;
        }
        return height;
    }
}