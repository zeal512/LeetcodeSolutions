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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        TreeNode root = build_binary_tree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length-1, inOrderMap);
        return root;
    }


    public static TreeNode build_binary_tree(int[] inorder, int in_order_start, int in_order_end, int[] preorder, int pre_order_start, int pre_order_end, Map<Integer, Integer> inOrderMap){
        
        if(in_order_start > in_order_end || pre_order_start > pre_order_end)  return null;
        
        TreeNode root = new TreeNode(preorder[pre_order_start]);
        
        int in_order_root = inOrderMap.get(root.val);
        int left_num_total = in_order_root - in_order_start;

        root.left = build_binary_tree(inorder, in_order_start, in_order_root-1, preorder, pre_order_start +1, pre_order_start + left_num_total, inOrderMap);

        root.right = build_binary_tree(inorder, in_order_root+1, in_order_end, preorder, pre_order_start+left_num_total+1, pre_order_end, inOrderMap);

        return root;
        }
}