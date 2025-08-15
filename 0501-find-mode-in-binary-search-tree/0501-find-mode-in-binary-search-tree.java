

import static java.lang.System.out;

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
    public int[] findMode(TreeNode root) {
        if(root == null) return new int[0];

        Map<Integer, Integer> modes = new HashMap<>();
        traverseDFS(root, modes);
        int maxFreq =0;
        for(int freq : modes.values()){ 
            maxFreq = Math.max(maxFreq , freq);
        }
        List<Integer> list = new ArrayList<>();
        
        for (int nodeVal : modes.keySet()) {
            if(modes.get(nodeVal) == maxFreq ){
                list.add(nodeVal);
            }
        }
        int[] output = new int[list.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = list.get(i);
        }
        
        return output;
    }

    public static void traverseDFS(TreeNode node, Map <Integer, Integer> modes){
        if (node == null) return;

        modes.put(node.val, modes.getOrDefault(node.val, 0)+1);

        traverseDFS(node.left, modes);
        traverseDFS(node.right, modes);
    }
}