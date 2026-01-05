class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum =0;
        int minAbsNegativeNum = Integer.MAX_VALUE, negativeNums = 0;
        for(int[] mat : matrix){
            for(int cell : mat){
                sum+=Math.abs(cell);
                if(cell < 0){
                    negativeNums+=1;
                }
                minAbsNegativeNum = Math.min(Math.abs(cell), minAbsNegativeNum);
            }
        }
        if(negativeNums %2 != 0){
            sum -= 2*minAbsNegativeNum;
        }
        return sum;
    }
}