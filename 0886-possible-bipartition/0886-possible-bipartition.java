class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] record = new int[n+1];
        Arrays.fill(record, -1);
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge : dislikes){
            int node1 = edge[0];
            int node2 = edge[1];
            if(!adjList.containsKey(node1)) adjList.put(node1, new ArrayList<>());
            if(!adjList.containsKey(node2)) adjList.put(node2, new ArrayList<>());
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
        for(int node = 1 ; node <= n; node++){
            if(record[node] == -1){
                if(!traverse(node, adjList, record, 1)) return false;
            }
        }
        return true;
    }
    public boolean traverse(int node, Map<Integer, List<Integer>> adjList, int[] record, int nodeVal){
        record[node] = nodeVal;
        List<Integer> disliked = adjList.get(node);
        if(disliked != null){
            for( int dislikedAdj : adjList.get(node)){
                if(record[dislikedAdj] == -1){
                    if(!traverse(dislikedAdj, adjList, record, 1 - nodeVal)) return false;
                }
                else if(record[dislikedAdj] == nodeVal) return false;
            }
        }
        return true;
    }
}

/* 
1 -> {2,3}
2 -> {1,4}
3 -> {1}
4 -> {2}
 */