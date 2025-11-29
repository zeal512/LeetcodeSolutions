class Solution {
    /* public int countBattleships(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        int battleships=0;
        for(int i=0; i< n; i++){
            for(int j=0; j< m; j++){
                if(board[i][j] == 'X' && !visited[i][j]){
                    visited[i][j] = true;
                    battleships+=1;
                    if(i+1 < n && board[i+1][j] == 'X'){
                        dfsRow(i+1, j, board, visited,n,m);
                    }
                    else if(j+1 < m && board[i][j+1] == 'X'){
                        dfsCol(i, j+1, board, visited,n,m);
                    }
                }
            }
        }
        return battleships;
    }

    public static void dfsRow(int r, int c, char[][] board, boolean[][] visited, int n, int m){
        visited[r][c]=true;
        if(r+1 >= 0 && r+1 < n && c >= 0 && c < m && !visited[r+1][c] && board[r+1][c] == 'X'){
            dfsRow(r+1, c, board, visited, n, m);
        }
    }

    public static void dfsCol(int r, int c, char[][] board, boolean[][] visited, int n, int m){
        visited[r][c]=true;
        if(r >= 0 && r < n && c+1 >= 0 && c+1 < m && !visited[r][c+1] && board[r][c+1] == 'X')
            dfsCol(r, c+1, board, visited, n, m);
    } */
    public int countBattleships(char[][] board) {
        int n = board.length, m = board[0].length, battleships =0;
        for(int i=0; i< n;i++){
            for(int j=0; j< m; j++){
                if(board[i][j]!= 'X') continue;
                if(i-1 >=0 && board[i-1][j] == 'X') continue;
                if(j-1 >=0 && board[i][j-1] == 'X') continue;
                battleships+=1;
            }
        }
        return battleships;
    }
}
