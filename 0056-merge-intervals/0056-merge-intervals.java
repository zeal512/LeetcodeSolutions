class Solution {
    public int[][] merge(int[][] intervals) {
        int size = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[][] res = new int[size][2];

        int i=0;
        int loopctr = 0;
        while (i < size) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            for (int k = i+1; k < size; k++) {
                if (intervals[k][0] <= end ) {
                    end = Math.max(end, intervals[k][1]);
                    i = k;
                }
                else{
                    break;
                }
            }
            res[loopctr][0] = start;
            res[loopctr][1] = end;
            loopctr ++;
            i++;
        }
        return Arrays.copyOfRange(res, 0, loopctr);
    }
}