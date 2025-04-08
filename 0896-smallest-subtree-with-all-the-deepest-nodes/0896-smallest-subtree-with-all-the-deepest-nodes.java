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
 public class Pair{
    TreeNode node;
    int depth;
    Pair(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
 }
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        Pair result = findSubtreeNode(root);
        return result.node;
    }
    public Pair findSubtreeNode(TreeNode node){
        if(node == null){
            return new Pair(null,0);
        }
        Pair left = findSubtreeNode(node.left);
        Pair right = findSubtreeNode(node.right);
        if(left.depth > right.depth){
            return new Pair(left.node, left.depth+1);
        }
        else if(right.depth > left.depth){
            return new Pair(right.node, right.depth+1);
        }
        else{
            return new Pair(node, left.depth+1);
        }
    }
}