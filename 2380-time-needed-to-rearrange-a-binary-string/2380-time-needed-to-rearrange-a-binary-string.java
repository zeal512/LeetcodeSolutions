class Solution {
    public int secondsToRemoveOccurrences(String s) {
        int n = s.length();
        int zeros = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                zeros += 1;
            } else {
                if(zeros > 0){
                    time = Math.max(zeros, time + 1);
                }
            }
        }
        return time;
    }
}