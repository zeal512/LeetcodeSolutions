class Solution {
    public int[][] merge(int[][] intervals) {
        int size = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> mergeList = new ArrayList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < size; i++) {
            int[] next = intervals[i];
            if(curr[1] >= next[0]){
                curr[1] = Math.max(curr[1], next[1]);
            }
            else{
                mergeList.add(curr);
                curr = next;
            }
        }
        mergeList.add(curr);
        return mergeList.toArray(new int[mergeList.size()][]);

        /* int i=0;
        while (i < size) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int k = i+1;
            while(k < size && intervals[k][0] <= end){
                end = Math.max(end, intervals[k][1]);
                k++;
            }
            mergeList.add(new int[]{start, end});
            i=k;
        }
        return mergeList.toArray(new int[mergeList.size()][]) ; */
    }
}