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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean nodeX = false, nodeY = false;
            for(int i=0; i<size; i++){
                TreeNode currentNode = queue.poll();
                if( currentNode.left != null && currentNode.right != null){
                if( (currentNode.left.val == x && currentNode.right.val == y) ||
                     (currentNode.left.val == y && currentNode.right.val == x) ){
                        return false;
                     }
                }
                if(currentNode.left != null){
                    queue.add(currentNode.left);
                    if(currentNode.left.val == x) nodeX = true;
                    if(currentNode.left.val == y) nodeY = true;
                }
                if(currentNode.right != null){
                    queue.add(currentNode.right);
                    if(currentNode.right.val == x) nodeX = true;
                    if(currentNode.right.val == y) nodeY = true;
                }
            }
            if(nodeX && nodeY) return true;
        }
        return false;
    }
}