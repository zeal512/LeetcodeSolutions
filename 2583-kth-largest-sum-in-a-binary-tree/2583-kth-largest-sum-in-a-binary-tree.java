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
    /* public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> pqueue = new PriorityQueue<>((a,b)-> Long.compare(b, a));
        queue.offer(root);
        while(!queue.isEmpty()){
            long sum = 0;
            int size = queue.size();
            for(int i =0; i < size; i++){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            pqueue.offer(sum);
        }
        if(pqueue.size() < k) return -1;
        while(k > 1){
            pqueue.poll();
            k-=1;
        }
        return pqueue.peek();
    } */
    public long kthLargestLevelSum(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        PriorityQueue<Long> pqueue = new PriorityQueue<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            long sum = 0;
            int size = queue.size();
            for(int i =0; i < size; i++){
                TreeNode node = queue.poll();
                sum+=node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            pqueue.offer(sum);
            if(pqueue.size()> k) pqueue.remove();
        }
        if(pqueue.size() < k) return -1;
        return pqueue.peek();
    }
}