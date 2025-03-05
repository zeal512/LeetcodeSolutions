class Solution {
    public long coloredCells(int n) {
        long toatalNumberOfCells =0;
        for(long i=1; i<=(2*n)-1; i++){
            if(i%2 != 0) toatalNumberOfCells+=i;
        }
        return (toatalNumberOfCells*2) - ((2*n)-1);
    }
}