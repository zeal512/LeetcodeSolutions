class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<Integer,List<Integer>>();
        boolean[] visited = new boolean[n];
        for(int i=0; i< n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adj.get(node2).add(node1);
            adj.get(node1).add(node2);
        }
        if(!dfs(0, -1, adj, visited)) return false;
        for(boolean res : visited){
            if(!res) return false;
        }
        return true;
    }
    public static boolean dfs(int node, int parent, Map<Integer, List<Integer>> adj, boolean[] visited){
        if(visited[node]) return false;
        visited[node] = true;
        for(int newNode : adj.get(node)){
            if(newNode == parent) continue;
            if(!dfs(newNode, node, adj, visited)) return false;
        }
        return true;
    }
}