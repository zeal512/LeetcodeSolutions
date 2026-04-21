class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int rows = score.length, cols = score[0].length;        
        int[] scoreOfKRow = new int[rows];
        
        Map<Integer, int[]> map = new HashMap<>();
        int[][] ans = new int[rows][cols];
        
        for(int i =0; i < rows; i++){
            scoreOfKRow[i] = score[i][k];
            map.put(score[i][k],score[i]);
        }
        Arrays.sort(scoreOfKRow);
        int ptr = 0;
        for(int i =rows -1; i >=0; i--){
            ans[ptr++] = map.get(scoreOfKRow[i]);
        }
        return ans;
    }
}

/* 
73553   35299   52319   75465   93775
31916   43095   68735   8047    85671
25535   65861   78607   987     74734
81389   14293   89623   42708   53978


 */