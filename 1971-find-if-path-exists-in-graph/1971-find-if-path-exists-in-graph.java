class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : edges){
            int v1 = edge[0];
            int v2 = edge[1];
            adjList.putIfAbsent(v1, new ArrayList<>());
            adjList.putIfAbsent(v2, new ArrayList<>());
            adjList.get(v1).add(v2);
            adjList.get(v2).add(v1);
        }
        System.out.println(adjList);
        boolean[] visited = new boolean[n];
        traverse(adjList, source, destination, visited);
        if(visited[destination]) return true;
        return false;
    }
    public void traverse(Map<Integer, List<Integer>> adjList, int node, int destination, boolean[] visited){
        if(visited[node] == true) return;
        if(node == destination){
            visited[destination] = true;
            return;
        }
        visited[node] = true;
        for(int next : adjList.get(node)){
            traverse(adjList, next, destination, visited);
        }
    }
}