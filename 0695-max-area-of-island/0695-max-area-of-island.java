class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int maxArea = 0;
        for(int i=0; i< m; i++){
            for(int j=0; j< n;j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    maxArea = Math.max(dfs(i,j,grid,visited), maxArea);
                }
                else visited[i][j] = true;
            }
        }
        return maxArea;
    }
    public static int dfs(int r,int c,int[][] grid, boolean[][] visited){
            if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) return 0;
            visited[r][c] = true;
            int[][] direction = {{0,1}, {0,-1},{1,0},{-1,0}};
            int area =1;
            for(int[] dir: direction){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(nr >=0 && nr < grid.length && nc >=0 && nc < grid[0].length && !visited[nr][nc] && grid[nr][nc] == 1){
                    area+= dfs(nr, nc, grid, visited);

                }
            }
            return area;
            
        }
}