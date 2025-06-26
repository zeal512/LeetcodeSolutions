class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (! ifExists(root, p) || ! ifExists(root, q) ) return null;
        return findLCA(root, p, q);
    }

    public static TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode leftNode = findLCA(root.left, p, q);
        TreeNode rightNode = findLCA(root.right, p, q);
        if(leftNode != null && rightNode != null) return root;

        return (leftNode != null)? leftNode:rightNode;
    }


    public static boolean ifExists(TreeNode node, TreeNode target){
        if(node == null) return false;
        if(node == target) return true;
        return ifExists(node.left, target) || ifExists(node.right, target);
    }
}