class Solution {
    TreeNode node1 = null, node2 = null, previous = null;
    
    public void recoverTree(TreeNode root) {
        traverseDFS(root);
        
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
    public void traverseDFS(TreeNode node){
        if(node == null) return;
        traverseDFS(node.left);
        if(previous != null && node.val < previous.val){
            if(node1 == null) node1 = previous;
            node2 = node;
        }
        previous = node;
        traverseDFS(node.right);
    }
}