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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if(root == null) return list;
        traverse(root, new StringBuilder(), list);
        return list;
    }

    public void traverse(TreeNode root, StringBuilder path, List<String> list){
        int len = path.length();
        path.append(root.val);
        if(root.left == null && root.right == null){ 
            list.add(path.toString());
        }
        else{
            path.append("->");
            if(root.left != null){
                traverse(root.left, path, list);
            }
            if(root.right != null){
                traverse(root.right, path, list);
            }
        }
        path.setLength(len);
    }
}