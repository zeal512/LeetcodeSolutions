class Solution {
    public static int fishes = 0;
    public int findMaxFish(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited= new boolean[rows][cols];
        int maxFishesPossible = 0;
        for(int i=0; i< rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    dfsTraversal(i,j,grid,visited, rows, cols);
                    maxFishesPossible = Math.max(maxFishesPossible, fishes);
                    fishes = 0;
                }
                visited[i][j] = true;
            }
        }
        return maxFishesPossible;
    }
    public static void dfsTraversal(int r,int c,int[][] grid, boolean[][] visited, int rows, int cols){
        if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] == 0 || visited[r][c]) return;
        visited[r][c] = true;
        fishes+=grid[r][c];
        dfsTraversal(r, c+1, grid, visited, rows, cols);
        dfsTraversal(r, c-1, grid, visited, rows, cols);
        dfsTraversal(r+1, c, grid, visited, rows, cols);
        dfsTraversal(r-1, c, grid, visited, rows, cols);
    }
}