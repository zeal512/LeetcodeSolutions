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
     int maxcurrLevelOfTree = 0;
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        traverse(root, 0, res);
        return res;
    }

    public void traverse(TreeNode node, int currLevel, List<Integer> res){
        if(node == null) return ;
        if(currLevel == maxcurrLevelOfTree){
            maxcurrLevelOfTree++;
            res.add(node.val);
        }
        traverse(node.right, currLevel+1, res);
        traverse(node.left, currLevel+1, res);
    }
}