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
    
    private int position, result;

    public int kthSmallest(TreeNode root, int k) {
        /* List<Integer> list = new ArrayList<>();
        traverseDFS(root, list);
        return list.get(k-1); */
        traverse(root, k);
        return result;
    }

    public void traverse(TreeNode node, int k){
        if(node == null) return;
        traverse(node.left,k);
        position+=1;
        if(position == k){
            result = node.val;
            return;
        }
        traverse(node.right, k);
    }
    
    /* public void traverseDFS(TreeNode root, List<Integer> list){
        if(root == null)return;

        traverseDFS(root.left, list);
        list.add(root.val);
        traverseDFS(root.right, list);
    } */

}