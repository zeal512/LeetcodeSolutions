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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for(int i=0; i< inorder.length; i++){
            inOrderMap.put(inorder[i], i);
        }
        TreeNode root = generateTree(inorder,0,inorder.length-1, postorder, 0, postorder.length-1, inOrderMap);
        return root;
    }
    public static TreeNode generateTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inOrderMap){
        if(inStart > inEnd || postStart > postEnd) return null;
        TreeNode root = new TreeNode(postorder[postEnd]);
        int inorderRoot = inOrderMap.get(root.val);
        int rightNum = inEnd - inorderRoot;
        root.left = generateTree(inorder, inStart, inorderRoot-1, postorder, postStart, postEnd - rightNum -1, inOrderMap);
        root.right = generateTree(inorder, inorderRoot + 1, inEnd, postorder, postEnd - rightNum, postEnd -1, inOrderMap);
        return root;
    }
}