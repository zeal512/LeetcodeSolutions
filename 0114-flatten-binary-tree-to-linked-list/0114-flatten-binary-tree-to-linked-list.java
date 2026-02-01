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
    public void flatten(TreeNode root) {
        dfsHelper(root);
    }
    public TreeNode dfsHelper(TreeNode node){
        if(node == null) return null;
        if(node.left == null && node.right == null) return node;
        TreeNode leftTail = dfsHelper(node.left);//3
        TreeNode rightTail = dfsHelper(node.right);
        if(leftTail != null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return rightTail == null? leftTail:rightTail;
    }
}
/* 
Intuition: traverse the tree in dfs pre-order traversal 
if you reach leftmost leaf node, that is your leftTail
after that, when you reach rightmost leaf node, that is rightTail, 

attach leftTail.right = node.right

and then attach the entire leftmost tree to node.right
node.right = node.left;

*/