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
 class NodePair{
    int num;
    TreeNode node;
    NodePair(TreeNode node, int num){
        this.num = num;
        this.node = node;
    }
 };

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth = 0;
        Queue<NodePair> queue = new LinkedList<>();
        queue.offer(new NodePair(root, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            int minimum = queue.peek().num, first = 0, last =0;
            for (int i = 0; i < size; i++) {
                int currentID = queue.peek().num - minimum;
                TreeNode currentNode = queue.peek().node;
                queue.poll();
                if(i==0) first = currentID; 
                if(i==size-1) last = currentID;
                if(currentNode.left != null) queue.offer(new NodePair(currentNode.left,(2*currentID) +1) );
                if (currentNode.right != null) queue.offer(new NodePair(currentNode.right, (2*currentID)+2));
            }
            maxWidth = Math.max(maxWidth, last-first+1);
        }
        return maxWidth;
    }
}