class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        /* for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = matrix[0].length-1;
                if (target == matrix[i][j]) return true;
                if (target > matrix[i][len]) {
                    break;
                }
            }
        }
        return false; */
        int m =matrix.length, n = matrix[0].length;
        int left =0, right = (m*n)-1;
        while (left <= right) {
            int mid = (left + right)/2;
            int i = mid/n, j=mid%n;
            if (matrix[i][j] == target) return true;
            else if(matrix[i][j] > target) right = mid-1;
            else left = mid+1;
        }
        return false;
    }
}