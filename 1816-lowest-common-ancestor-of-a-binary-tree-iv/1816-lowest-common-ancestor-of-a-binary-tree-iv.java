/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        HashSet<Integer> set = new HashSet<>();
        for(TreeNode node: nodes){
            set.add(node.val);
        }
        TreeNode returnNode = traverse(root, set);
        return returnNode;
    }
    
    public TreeNode traverse(TreeNode node, HashSet<Integer> set){
        if(node == null || set.contains(node.val)) return node;
        TreeNode left = traverse(node.left, set);
        TreeNode right = traverse(node.right, set);

        if(left == null) return right;
        else if(right == null) return left;
        else return node;
    }
}