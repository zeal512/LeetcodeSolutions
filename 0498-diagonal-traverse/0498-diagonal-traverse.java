class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int row = mat.length, col = mat[0].length, counter = 0;
        int[] result = new int[row*col];
        int direction =1;
        int r=0, c=0;
        while (r<row && c < col) {
            result[counter++] = mat[r][c];
            int newRow = (direction == 1 ? -1:1) + r;
            int newCol = (direction == 1 ? 1:-1) + c;
            if (newRow < 0 || newRow == row || newCol < 0 || newCol == col) {
                if (direction == 1) {
                    r = r+ (c == col-1?1:0);
                    c = c+ (c < col-1? 1:0);
                }
                else{
                    c = c+ (r == row-1? 1:0);
                    r = r+ (r < row-1?1:0);
                }
                direction = 1 - direction;
            }else{
                r = newRow;
                c = newCol;
            }
        }
       return result;
    }
}