

import static java.lang.Integer.min;

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

    public static void create_parent_node_directoyy(TreeNode root, Map<TreeNode, TreeNode> parent_node_directory){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode current_node = queue.poll();
            if (current_node.left != null) {
                parent_node_directory.put(current_node.left, current_node);
                queue.add(current_node.left);
            }
            if(current_node.right != null){
                parent_node_directory.put(current_node.right, current_node);
                queue.add(current_node.right);
            }
        }
    }

    public static TreeNode find_start_node(TreeNode node, int start){
        if(node == null) return null;
        if(node.val == start) return node;
        TreeNode start_node = find_start_node(node.left, start);
        if(start_node != null) return start_node;
        return find_start_node(node.right, start);
    }
    
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parent_node_directory = new HashMap<>();
        create_parent_node_directoyy(root, parent_node_directory);

        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> infected = new HashMap<>();
        TreeNode start_node = find_start_node(root, start);
        
        queue.offer(start_node);
        infected.put(start_node, true);
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i < size; i++){
                TreeNode current_infected_node = queue.poll();
                if(current_infected_node.left != null && infected.get(current_infected_node.left) == null){
                    queue.add(current_infected_node.left);
                    infected.put(current_infected_node.left, true);
                }
                if (current_infected_node.right != null && infected.get(current_infected_node.right) == null) {
                    queue.add(current_infected_node.right);
                    infected.put(current_infected_node.right, true);
                }
                TreeNode parent_node = parent_node_directory.get(current_infected_node);
                if (parent_node!= null && infected.get(parent_node) == null ) {
                    queue.add(parent_node);
                    infected.put(parent_node, true);
                }
            }
            if(!queue.isEmpty()) minutes++;
        }
        return minutes;
    }
}