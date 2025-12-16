class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        boolean canAttend = true;
        if(intervals.length == 0) return canAttend;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int prevEndTime = intervals[0][1];
        for(int i = 1; i< intervals.length; i++){
            if(intervals[i][0] < prevEndTime) return false;
            prevEndTime = intervals[i][1];
        }
        return canAttend;
    }
}