class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean firstColHasZero = false, firstRowHasZero = false;
        for(int i=0; i< row; i++){
            if(matrix[i][0] == 0) firstColHasZero = true;
        }
        for(int i=0; i< col; i++){
            if(matrix[0][i] == 0) firstRowHasZero = true;
        }
        
        for(int i=1; i< row; i++){
            for(int j=1; j< col; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int r=1; r< row; r++){
            for(int c = 1; c < col; c++){
                if(matrix[r][0] == 0 || matrix[0][c] == 0){
                    matrix[r][c] =0;
                }
            }
        }

        if(firstRowHasZero){
            for(int i=0; i< col; i++) matrix[0][i] =0;
        }

        if(firstColHasZero){
            for(int j=0; j< row; j++) matrix[j][0] =0;
        }
    }
}