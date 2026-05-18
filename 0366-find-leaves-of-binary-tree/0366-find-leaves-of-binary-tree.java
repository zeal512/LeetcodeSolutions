
class Solution {
    public List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        traverse(root);
        return result;
    }
    public int traverse(TreeNode node){
        if(node == null){
            return -1;
        }
        int leftHeight = traverse(node.left);
        int rightHeight = traverse(node.right);
        int currHeight = Math.max(leftHeight, rightHeight)+1;
        if(result.size() == currHeight) result.add(new ArrayList<>());
        result.get(currHeight).add(node.val);
        return currHeight;
    }
}