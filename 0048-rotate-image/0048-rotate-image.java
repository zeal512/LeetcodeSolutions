class Solution {
    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        reverseLeftToRight(matrix);
    }
    public void transposeMatrix(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i< n; i++){
            for(int j = i+1; j< n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void reverseLeftToRight(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i< n; i++){
            for(int j=0; j<n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }
}


/* 
1. Transpose meaning a[i][j] will be swapped with a[j][i]
2. Reverse
 */