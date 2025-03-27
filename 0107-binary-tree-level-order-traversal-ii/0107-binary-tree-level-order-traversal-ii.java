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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if(root == null) return traversal;
        int depth = calculateDepth(root);
        for(int i=0; i< depth; i++){
            traversal.add(new ArrayList<>());
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i=0; i< size; i++){
                TreeNode curr = queue.poll();
                list.add(curr.val);
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
            traversal.set(depth-1, list);
            depth -=1;
        }
        return traversal;
    }

    public static int calculateDepth(TreeNode node){
        if(node == null) return 0;
        int leftDepth = calculateDepth(node.left);
        int rightDepth = calculateDepth(node.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }
}