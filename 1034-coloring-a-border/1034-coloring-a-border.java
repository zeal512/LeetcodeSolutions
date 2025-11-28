

import javax.swing.border.Border;

class Solution{    
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int n = grid.length, m = grid[0].length;
        int source = grid[row][col];
        boolean[][] visited = new boolean[n][m];

        dfs(row, col, grid, source, n,m, visited,color);
        
        return grid;
    
    }
    public static void dfs(int r, int c, int[][] grid, int source, int n, int m, boolean[][] visited, int color){
        if(r < 0 || c < 0 || r >=n || c >= m || grid[r][c] != source || visited[r][c]) return;
        
        visited[r][c] = true;
        boolean isBorder = false;
        
        if(r == 0 || c == 0 || r == n -1 || c == m-1 || grid[r-1][c] != source || grid[r+1][c] != source || grid[r][c-1] != source || grid[r][c+1] != source) isBorder = true;

        dfs(r+1, c, grid, source, n,m,visited,color);
        dfs(r-1, c, grid, source, n,m,visited,color);
        dfs(r, c+1, grid, source, n,m,visited,color);
        dfs(r, c-1, grid, source, n,m,visited,color);
        
        if(isBorder){
            grid[r][c] = color;
        }
    }
}