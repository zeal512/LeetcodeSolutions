class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++){
            for(int j=0; j< 9; j++){
                if(board[i][j] != '.'){
                    if(!isValid(board, i, j)) return false;
                }
            }
        }
        return true;
    }
    
    public static boolean isValid(char[][] board, int row, int col){
        char c = board[row][col];
        for(int i=0; i<9; i++){
            if(board[row][i] == c && i != col) return false;
            if(board[i][col] == c && i != row) return false;
        }
        int bRow = (row/3)*3;
        int bCol = (col/3)*3;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                int nRow = bRow + i;
                int nCol = bCol + j;
                if(nRow == row && nCol == col) continue;
                if(board[nRow][nCol] == c) return false;
            }
        }

        return true;
    }
}