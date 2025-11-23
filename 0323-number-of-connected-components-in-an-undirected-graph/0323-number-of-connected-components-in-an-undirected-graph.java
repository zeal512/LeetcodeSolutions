class Solution {
    public int countComponents(int n, int[][] edges) {
        //int[][] isConnected = new int[n][n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i< n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int i = 0; i<edges.length;i++){
            /* int node1 = edges[i][0];
            int node2 = edges[i][1];
            isConnected[node1][node2] = 1;
            isConnected[node2][node1] = 1; */
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        int connectedComponents = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                connectedComponents+=1;
                dfs(map, i, visited, n);
                // dfs(isConnected, i, visited, n);
            }
        }
        return connectedComponents;
    }
    /* public static void dfs(int[][] isConnected, int node, boolean[] visited, int n){
        visited[node] = true;
        for(int i = 0; i< isConnected.length; i++){
            if(isConnected[node][i] == 1 && !visited[i] ){
                dfs(isConnected,i,visited, n);
            }
        }
    } */
    public static void dfs(Map<Integer, List<Integer>> map, int node, boolean[] visited, int n){
        visited[node] = true;
        List<Integer> adjList = map.get(node);
        for(int newNode : adjList){
            if(!visited[newNode]) dfs(map, newNode, visited, n);
        }
    }
}