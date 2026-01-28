class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i=0; i< 4; i++){
            if(equal(mat, target)) return true;
            rotateMatrix(mat);
        }
        return false;
    }
    public boolean equal(int[][] mat, int[][] target){
        int n = mat.length;
        for(int row =0; row < n; row++){
            for(int col =0; col < n; col++){
                if(mat[row][col] != target[row][col]) return false;
            }
        }
        return true;
    }
    public void rotateMatrix(int[][] mat){
        int n = mat.length;
        transpose(mat);
        for(int row =0; row < n; row++){
            int left =0, right = n-1;
            while(left < right){
                int temp = mat[row][left];
                mat[row][left] = mat[row][right];
                mat[row][right] = temp;
                right--;
                left++;
            }
        }
    }
    public void transpose(int[][] mat){
        int n = mat.length;
        for(int row = 0; row < n; row++){
            for(int col =row+1; col < n; col++){
                int temp = mat[row][col];
                mat[row][col] = mat[col][row];
                mat[col][row] = temp;
                
            }
        }
    }
}

/* 
0,0,0
0,1,0
1,1,1

0,0,1
0,1,1
0,0,1

1,0,0
1,1,0
1,0,0
*/