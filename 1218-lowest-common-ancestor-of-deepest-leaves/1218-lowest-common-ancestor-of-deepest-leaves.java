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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair result = findLCA(root);
        
        return result.node;

    }

    public Pair findLCA(TreeNode node){
        if(node == null ){
            return new Pair(null, 0);
        }
        Pair left =findLCA(node.left);
        Pair right = findLCA(node.right);
        
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