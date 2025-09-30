/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public static void trackParentNodes(TreeNode root, Map<TreeNode, TreeNode> parentNode_records) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current_Node = queue.poll();
            if (current_Node.left != null) {
                parentNode_records.put(current_Node.left, current_Node);
                queue.offer(current_Node.left);
            }
            if (current_Node.right != null) {
                parentNode_records.put(current_Node.right, current_Node);
                queue.offer(current_Node.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentNode_records = new HashMap<>();
        trackParentNodes(root, parentNode_records);

        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int level_traversed = 0;

        while (!queue.isEmpty()) {
            if (level_traversed == k)
                break;
            level_traversed++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode current_node = queue.poll();
                if (current_node.left != null && visited.get(current_node.left) == null) {
                    visited.put(current_node.left, true);
                    queue.offer(current_node.left);
                }
                if (current_node.right != null && visited.get(current_node.right) == null) {
                    visited.put(current_node.right, true);
                    queue.offer(current_node.right);
                }
                if (parentNode_records.get(current_node) != null
                        && visited.get(parentNode_records.get(current_node)) == null) {
                    visited.put(parentNode_records.get(current_node), true);
                    queue.offer(parentNode_records.get(current_node));
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            result.add(node.val);
        }
        return result;
    }
}