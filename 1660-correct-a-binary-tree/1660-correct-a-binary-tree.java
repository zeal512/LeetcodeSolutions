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

    public TreeNode correctBinaryTree(TreeNode root) {
        
        Queue<TreeNode[]> queue = new LinkedList<>();
        queue.add(new TreeNode[]{root, null});
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<Integer> visited = new HashSet<>();
            
            for(int i=0; i< size; i++){
                TreeNode[] currPair = queue.poll();
                TreeNode currNode = currPair[0], parent = currPair[1];

                if(currNode.right != null && visited.contains(currNode.right.val)){
                    if(parent.left == currNode){
                        parent.left = null;
                    }else parent.right = null;
                    return root;
                }
                visited.add(currNode.val);
                if(currNode.right != null){
                    queue.add(new TreeNode[]{currNode.right, currNode});
                }
                if(currNode.left != null){
                    queue.add(new TreeNode[]{currNode.left, currNode});
                }
            }
            visited.clear();
        }
        return root;
    } 

}