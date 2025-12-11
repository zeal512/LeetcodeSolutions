class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] left =  new int[n+1];
        int[] right = new int[n+1];
        int[] top =  new int[n+1];
        int[] bottom = new int[n+1];
        Arrays.fill(left, Integer.MAX_VALUE);
        Arrays.fill(top, Integer.MAX_VALUE);
        int count = 0;
        for(int[] building : buildings){
            int x = building[0];
            int y = building[1];
            left[y] = Math.min(left[y], x);
            right[y] = Math.max(right[y], x);
            top[x] = Math.min(top[x], y);
            bottom[x] = Math.max(bottom[x], y);
        }
        // System.out.println("top: " +top+ ", bottom: "+bottom + ", left: "+left+", right:"+right );
        for(int[] building : buildings){
            int x = building[0], y = building[1];
            if( x > left[y] && x < right[y] && y < bottom[x] && y > top[x]) {
                count+=1;
            }
        }
        return count;
    }
}