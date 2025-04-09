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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return result;
        findPath(root, targetSum, result,list,0);
        return result;
    }

    public void findPath(TreeNode node, int targetSum, List<List<Integer>> result,
     List<Integer> list, int sum){
        if(node == null) return;
        sum += node.val;
        list.add(node.val);
        if(node.left == null && node.right == null && sum == targetSum){
            result.add(new ArrayList<>(list));
        }else{
            findPath(node.left, targetSum, result, list, sum);
            findPath(node.right, targetSum, result, list, sum);
        }
        list.remove(list.size()-1);
    }
}