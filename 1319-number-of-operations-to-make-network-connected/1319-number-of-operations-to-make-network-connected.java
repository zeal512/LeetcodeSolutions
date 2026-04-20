class Solution {
    public int makeConnected(int n, int[][] connections) {
        
        if(n-1 > connections.length) return -1;
        
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        int total_clusters = 0;
        boolean[] visited = new boolean[n];
        
        for(int[] connection : connections){
            adjList.putIfAbsent(connection[0], new ArrayList<>());
            adjList.putIfAbsent(connection[1], new ArrayList<>());

            adjList.get(connection[0]).add(connection[1]);
            adjList.get(connection[1]).add(connection[0]);
        }
        
        for(int i =0; i< n; i++){
            if(!adjList.containsKey(i)){
                total_clusters+=1;
                visited[i] = true;
            }
            if(!visited[i]){
                traverse(i, adjList, visited);
                total_clusters+=1;
            }
        } 
        return total_clusters-1;
    }
    public void traverse(int node, Map<Integer, ArrayList<Integer>> adjList, boolean[] visited){
        if(visited[node]) return;
        visited[node] = true;
        
        for(int neighbour: adjList.get(node)){
            if(!visited[neighbour]) traverse(neighbour, adjList, visited);
        }
    }
}

/* 
    3   4
    |
    0 - 1 
    | /
    2   5

*/