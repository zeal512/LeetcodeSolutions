class Solution {
    public int getMaximumGold(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxGold = 0;
        for(int i = 0; i < rows; i ++){
            for(int j =0; j < cols; j++){
                if(grid[i][j]!= 0){                    
                    maxGold = Math.max(maxGold, dfs(i, j, visited, grid));
                }
            }
        }
        return maxGold;
    }
    public int dfs(int r, int c, boolean[][] visited, int[][] grid){
        if(
            r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || 
            grid[r][c] == 0 || visited[r][c] 
            ){
                return 0;
            }
        visited[r][c] = true;
        int gold = grid[r][c];
        
        int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];
            gold = Math.max(gold, grid[r][c] + dfs(nr, nc, visited, grid));
        }
        visited[r][c] = false;
        return gold;
    }
}