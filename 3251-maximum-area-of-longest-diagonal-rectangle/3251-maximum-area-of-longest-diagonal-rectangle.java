
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        double maxDiagonal = 0.0;
        for(int i=0; i< dimensions.length; i++){
            int length = dimensions[i][0], width = dimensions[i][1];
            double diagonal = Math.sqrt((length * length) + (width * width));
            int area = length * width;

            if (diagonal > maxDiagonal || (diagonal == maxDiagonal && area > maxArea) ) {
                maxArea = area;
                maxDiagonal = diagonal;
            }
        }
        return maxArea;
    }
}