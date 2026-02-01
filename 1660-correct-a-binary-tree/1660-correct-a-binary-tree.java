

import javax.crypto.Cipher;

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
 class Pair{
    TreeNode node, parent;
    Pair(TreeNode node, TreeNode parent){
        this.node = node;
        this.parent = parent;
    }
 };
class Solution {
    public TreeNode correctBinaryTree(TreeNode root) {
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, null));
        
        
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<Integer> visited = new HashSet<>();
            
            for(int i=0; i< size; i++){
                Pair cur = queue.poll();
                TreeNode currNode = cur.node, parent = cur.parent;

                if(currNode.right != null && visited.contains(currNode.right.val)){
                    if(parent.left == currNode){
                        parent.left = null;
                    }else parent.right = null;
                    return root;
                }
                visited.add(currNode.val);
                if(currNode.right != null){
                    queue.add(new Pair(currNode.right, currNode));
                }
                if(currNode.left != null){
                    queue.add(new Pair(currNode.left, currNode));
                }
            }
            visited.clear();
        }
        return root;
    }
}