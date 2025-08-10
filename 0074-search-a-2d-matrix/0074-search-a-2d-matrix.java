class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = matrix[0].length-1;
                if (target == matrix[i][j]) return true;
                if (target > matrix[i][len]) {
                    break;
                }
            }
        }
        return false;
    }
}