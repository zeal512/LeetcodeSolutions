class Solution {
    
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedTree = new ArrayList<>();
        generateBSTList(root, sortedTree);
        System.out.println(sortedTree);
        return constructBBST(0, sortedTree.size()-1, sortedTree);
    }

    public void generateBSTList(TreeNode node, List<Integer> sortedTree){
        if(node == null) return;
        generateBSTList(node.left, sortedTree);
        sortedTree.add(node.val);
        generateBSTList(node.right, sortedTree);
    }

    public TreeNode constructBBST(int left, int right, List<Integer> sortedTree){
        if(left > right) return null;
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(sortedTree.get(mid));
        root.left = constructBBST(left, mid-1, sortedTree);
        root.right = constructBBST(mid+1, right, sortedTree);
        return root;
    }
}