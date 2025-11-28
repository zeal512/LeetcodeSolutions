class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int perimeter =0; 
        int[][] direction = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0; i< row; i++){
            for(int j=0; j< col; j++){
                if(grid[i][j] == 1){
                    perimeter+=4;
                    for(int[] dir : direction){
                        int r = i + dir[0];
                        int c = j + dir[1];
                        if(r >=0 && r < row && c >=0 && c < col && grid[r][c] == 1) perimeter-=1;
                    }
                }
            }
        }
        return perimeter;
    }
}