class BSTIterator {
    public ArrayList<Integer> sortedTree;
    public int idx;

    public BSTIterator(TreeNode root) {
        this.sortedTree = new ArrayList<>();
        this.idx = -1;
        traverseDFS(root);
    }
    
    public int next() {
        this.idx+=1;
        return sortedTree.get(idx);
    }
    
    public boolean hasNext() {
        return this.idx +1 < sortedTree.size();
    }

    public void traverseDFS(TreeNode node){
        if(node == null) return;
        traverseDFS(node.left);
        sortedTree.add(node.val);
        traverseDFS(node.right);
    }
}