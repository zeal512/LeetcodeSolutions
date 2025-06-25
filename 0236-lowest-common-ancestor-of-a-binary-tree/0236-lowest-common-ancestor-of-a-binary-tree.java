class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        List<TreeNode> pathOfP = new ArrayList<>();
        traverseDFS(root, p, pathOfP);
        
        List<TreeNode> pathOfQ = new ArrayList<>();
        traverseDFS(root, q, pathOfQ);
        
        for (int i = pathOfQ.size()-1; i >=0; i--) {
            if (pathOfP.contains(pathOfQ.get(i))) {
                return pathOfQ.get(i);
            }
        }
        return root;
    }

    public static boolean traverseDFS(TreeNode node, TreeNode targetNode,  List<TreeNode> path ){
        if (node == null) {
            return false;
        }
        path.add(node);
        if (node == targetNode) {
            return true;
        }
        
        if(traverseDFS(node.left, targetNode, path) || traverseDFS(node.right, targetNode, path)) {
            return true;
        }

        path.remove( path.size()-1 );
        return false;
    }
}