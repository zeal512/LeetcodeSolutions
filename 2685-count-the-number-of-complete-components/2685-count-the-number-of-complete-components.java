class Solution {
    public static int totalNodes = 0, totalEdges = 0;
    public int countCompleteComponents(int n, int[][] edges) {
        //List<List<Integer>> adjList = new ArrayList<>();
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int i =0; i< n; i++){
            //adjList.add(new ArrayList<>());
            adjList.put(i,new ArrayList<>());
        }
        for(int[] edge: edges){
            int node1 = edge[0];
            int node2 = edge[1];
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
        int completeConnectedComponents = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i< n; i++){
            if(!visited.contains(i)){
                totalEdges = 0;
                totalNodes = 0;
                dfs(i, adjList, visited);
                if(totalEdges == (totalNodes * (totalNodes -1))){
                    completeConnectedComponents+=1;
                }
            }
        }
        return completeConnectedComponents;
    }
    public static void dfs(int node, Map<Integer, List<Integer>> adjList, Set<Integer> visited){
    //public static void dfs(int node, List<List<Integer>> adjList, Set<Integer> visited){

        visited.add(node);
        totalNodes++;
        totalEdges += adjList.get(node).size();
        for(int neighbour: adjList.get(node)){
            if(!visited.contains(neighbour)){
                dfs(neighbour, adjList, visited);
            }
        }
    }
}