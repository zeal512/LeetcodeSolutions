class Solution {
    public int minimumArea(int[][] grid) {
        int left=Integer.MAX_VALUE, right=0, up=Integer.MAX_VALUE,down=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1) {
                    up = Math.min(up, i);
                    down = Math.max(down, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }
        return (down - up +1) * (right- left +1);
    }
}