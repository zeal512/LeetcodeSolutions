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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(isLeaf(root) == false) list.add(root.val);
        traverseLeftBoundry(root, list);
        traverseLeaf(root, list);
        traverseRightBoundry(root, list);
        return list;
    }
    public static void traverseLeftBoundry(TreeNode root, List<Integer> list){
        TreeNode currNode = root.left;
        while(currNode != null){
            if(isLeaf(currNode) == false) list.add(currNode.val);
            if(currNode.left != null) currNode = currNode.left;
            else currNode = currNode.right;
        }
        return;
    }

    public static void traverseRightBoundry(TreeNode root, List<Integer> list){
        TreeNode currNode = root.right;
        List<Integer> tempList = new ArrayList<>();
        while(currNode != null){
            if(isLeaf(currNode) == false) tempList.add(currNode.val);
            if(currNode.right != null) currNode = currNode.right;
            else currNode = currNode.left;
        }
        for(int i=tempList.size()-1; i>=0; i--){
            list.add(tempList.get(i));
        }
        return;
    }

    public static void traverseLeaf(TreeNode root,  List<Integer> list){
        if(isLeaf(root)){
             list.add(root.val);
             return;
        }
        if(root.left != null) traverseLeaf(root.left, list);
        if(root.right != null) traverseLeaf(root.right, list);
        return;
    }

    public static boolean isLeaf(TreeNode node){
        if(node.left == null && node.right == null) return true;
        return false;
    }
}