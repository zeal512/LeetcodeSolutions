class Solution {
    public int findCircleNum(int[][] isConnected) {
        int size = isConnected.length;
        boolean[] visited = new boolean[size];
        Arrays.fill(visited, false);
        int numberOfProvinces = 0;
        for(int i = 0; i < size; i++){
            if(!visited[i]){
                numberOfProvinces+=1;
                dfs(isConnected, i, visited);
            }
        }
        return numberOfProvinces;
    }
    public static void dfs(int[][] isConnected, int node, boolean[] visited){
        visited[node] = true;
        for(int i = 0; i< isConnected.length; i++){
            if(isConnected[node][i] == 1 && !visited[i] ){
                dfs(isConnected,i,visited);
            }
        }
    }
}