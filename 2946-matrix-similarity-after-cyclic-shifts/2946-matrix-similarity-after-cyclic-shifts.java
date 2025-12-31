class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int newIndex = (j + k) % col;
                if (mat[i][j] != mat[i][newIndex])return false;
            }
        }
        return true;
    }
}