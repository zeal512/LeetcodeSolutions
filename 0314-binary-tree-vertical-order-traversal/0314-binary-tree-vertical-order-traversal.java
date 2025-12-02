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
    TreeNode node;
    int row, col;
    Pair(TreeNode node, int col){
        this.node = node;
        this.col = col;
    }
};
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int minCol = 0, maxCol = 0;
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            TreeNode node = curr.node;
            int col = curr.col;
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(node.val);
            if(node.left != null){
                queue.offer(new Pair(node.left, col-1));
                minCol = Math.min(minCol, col-1);
            }
            if(node.right != null){
                queue.offer(new Pair(node.right, col+1));
                maxCol = Math.max(maxCol, col+1);
            }
        }
        for(int i = minCol; i<= maxCol; i++){
            list.add(map.get(i));
        }
        return list;
    }
}