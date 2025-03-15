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
    public boolean isSymmetric(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        TreeNode right = invertTree(root.right);
        return checkIfSame(root.left, right);
    }

    public static TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    public static boolean checkIfSame(TreeNode l, TreeNode r){
        if(l == null && r == null) return true;
        if((l == null && r != null) || (l != null && r == null)) return false;
        if(l.val != r.val) return false;
        return checkIfSame(l.left, r.left) && checkIfSame(l.right, r.right);
    }
}