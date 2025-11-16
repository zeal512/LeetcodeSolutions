class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        for(int i=0; i< row; i++){
            for(int j=0; j< col; j++){
                if(board[i][j] == word.charAt(0)){
                    boolean[][] visited = new boolean[row][col];
                    if(search(i,j,board,word,visited,row,col,1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean search(int r,int c,char[][] board, String word, boolean[][] visited,int row, int col, int ptr){
        if(ptr == word.length()) return true;
        visited[r][c] = true;
        int[] rDir = {-1,1,0,0};
        int[] cDir = {0,0,-1,1};
        for(int i=0; i< rDir.length; i++){
            int newRow = r + rDir[i];
            int newCol = c + cDir[i];
            if(newRow >=0 && newRow < row && newCol >=0 && newCol < col && !visited[newRow][newCol] && word.charAt(ptr) == board[newRow][newCol]){
                if(search(newRow, newCol, board, word, visited, row, col, ptr+1)) return true;
            }
        }
        visited[r][c] = false;
        return false;
    }
}