class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length, n = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i< m; i++){
            for(int j=0; j< n; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new int[]{i,j,0});
                }
            }
        }
        int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int cr = curr[0], cc = curr[1], currDistance = curr[2];;
            for(int dir[]:direction){
                int nr = cr + dir[0];
                int nc = cc + dir[1];

                if(nr >=0 && nr < m && nc >=0 && nc < n && rooms[nr][nc] == Integer.MAX_VALUE){
                    if(rooms[nr][nc] != 0 && rooms[nr][nc] != -1){
                        rooms[nr][nc] = Math.min(rooms[nr][nc], currDistance+1);
                        queue.offer(new int[]{nr,nc,currDistance+1});
                    }
                }
            }
        }
    }
}

/* 
[2147483647,    -1,             0,          2147483647]
[2147483647,  2147483647,   2147483647,             -1]
[2147483647,    -1,         2147483647,             -1]
[   0,          -1,         2147483647,     2147483647]]


*/