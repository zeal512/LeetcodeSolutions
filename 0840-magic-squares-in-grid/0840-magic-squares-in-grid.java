class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int magicGridCount = 0;
        if(rows < 3 || cols < 3) return magicGridCount;
        for(int i=0;i + 2 < rows; i++){
            for(int j =0; j + 2 < cols; j++){
                if(checkForMagicGrid(grid, i, j)) magicGridCount+=1;
            }
        }
        return magicGridCount;
    }

    public static boolean checkForMagicGrid(int[][] grid, int startRow, int startCol){
        int row1Sum = 0, row2Sum = 0, row3Sum = 0, col1Sum = 0, col2Sum = 0, col3Sum = 0, diagonal1Sum = 0, diagonal2Sum = 0;
        Set<Integer> unique = new HashSet<>();
        for(int i =0; i <3; i++){
            for(int j =0; j<3; j++){
                int currNum = grid[i + startRow][j+startCol];
                if(currNum < 1 || currNum > 9) return false;
                if(unique.contains(currNum)) return false;
                unique.add(currNum);
            }
        }
        diagonal1Sum += grid[startRow][startCol] + grid[startRow +1][startCol+1] + grid[startRow+2][startCol+2]; 
        diagonal2Sum += grid[startRow][startCol+2] + grid[startRow+1][startCol+1] + grid[startRow+2][startCol];
        if(diagonal1Sum != diagonal2Sum) return false;
        
        row1Sum += grid[startRow][startCol] + grid[startRow][startCol+1] + grid[startRow][startCol + 2];
        row2Sum += grid[startRow+1][startCol] + grid[startRow+1][startCol+1] + grid[startRow+1][startCol + 2];
        row3Sum += grid[startRow+2][startCol] + grid[startRow+2][startCol+1] + grid[startRow+2][startCol + 2];
        
        if((row1Sum != diagonal1Sum) || (row2Sum != diagonal1Sum) || (row3Sum != diagonal1Sum)) return false;

        col1Sum += grid[startRow][startCol] + grid[startRow+1][startCol] + grid[startRow + 2][startCol];
        col2Sum += grid[startRow][startCol + 1] + grid[startRow+1][startCol + 1] + grid[startRow + 2][startCol + 1];
        col3Sum += grid[startRow][startCol + 2] + grid[startRow+1][startCol + 2] + grid[startRow + 2][startCol+2];

        if((col1Sum != diagonal1Sum) || (col2Sum != diagonal1Sum) || (col3Sum != diagonal1Sum)) return false;
        return true;

    }
}