// Definition for a Node.
/* class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {    
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Node> hierarchy = new HashSet<>();
        while (p != null) {
            hierarchy.add(p);
            p = p.parent;
        } 
        while (q != null) {
            if (hierarchy.contains(q)) {
                return q;
            }
            hierarchy.add(q);
            q = q.parent;
        }
        return null;
    }
}