

import static java.lang.Math.max;

class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int maxArea = 0;
        double diagonal = 0.0;
        for(int i=0; i< dimensions.length; i++){
            int length = dimensions[i][0], width = dimensions[i][1];
            double var = Math.sqrt((length * length) + (width * width));
            if (var > diagonal) {
                maxArea = length * width;
            }else if (var == diagonal){
                maxArea = Math.max(maxArea, length * width);
            }
            diagonal = Math.max(var, diagonal) ;
        }
        return maxArea;
    }
}