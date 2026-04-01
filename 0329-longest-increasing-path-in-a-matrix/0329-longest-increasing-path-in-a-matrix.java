class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][] memo = new int[rows][cols];
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        int diagonal = 0;
        for(int i =0; i< rows; i++){
            for(int j =0; j< cols; j++){
                diagonal = Math.max(traverse(i, j, matrix, memo, directions), diagonal);
            }
        }
        return diagonal;
    }
    public int traverse(int r,int c, int[][] matrix, int[][] memo, int[][] directions){
        if(memo[r][c] != 0) return memo[r][c];
        for(int[] direction : directions){
            int nr = r + direction[0];
            int nc = c + direction[1];
            if(nr >=0 && nr < matrix.length && nc >=0 && nc < matrix[0].length && matrix[nr][nc] > matrix[r][c]){
                memo[r][c] = Math.max(memo[r][c], traverse(nr, nc, matrix, memo, directions));
            }
        }
        memo[r][c] = memo[r][c]+1;
        return memo[r][c];
    }
}