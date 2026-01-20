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
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> unique = new HashSet<>();
        //createSet(root, unique);
        return checkForPair(root, k, unique);
    }
/*     public void createSet(TreeNode node, Set<Integer> set){
        if(node == null){
            return;
        }
        set.add(node.val);
        if(node.left != null) createSet(node.left, set);
        if(node.right != null) createSet(node.right, set);
    } */

    public boolean checkForPair(TreeNode node, int target, Set<Integer> set){
        if(node == null) return false;
        int num1 = node.val;
        int num2 = target - num1;
        if(set.contains(num2)) return true;
        set.add(num1);
        return checkForPair(node.left, target, set) || checkForPair(node.right, target, set);
    }
}