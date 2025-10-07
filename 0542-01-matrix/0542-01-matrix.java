class Pair{
    int row;
    int col;
    int distance;
    Pair(int row, int col, int distance){
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] visited = new int[m][n];
        int[][] result = new int[m][n];
        Queue<Pair> queue = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j =0; j<n;j++){
                if(mat[i][j]==0){
                    queue.add(new Pair(i,j,0));
                    visited[i][j] =1;
                    result[i][j] = 0;
                }
            }
        }

        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,-1,0,1};

        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().col;
            int dist = queue.peek().distance;
            queue.remove();
            result[r][c] = dist;
            for(int i=0;i<dRow.length;i++){
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];
                if(nRow >=0 && nRow<m && nCol >=0 && nCol < n && visited[nRow][nCol] == 0){
                    visited[nRow][nCol] = 1;
                    queue.add(new Pair(nRow, nCol, dist+1));
                   }
            }
        }

        return result;

    }
}