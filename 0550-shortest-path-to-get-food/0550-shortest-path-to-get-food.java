class Solution {
    public int getFood(char[][] grid) {
        //1. find the start location
        int rowSize = grid.length;
        int colSize = grid[0].length;
        int[] startLocation = new int[]{-1,-1};
        boolean[][] visited = new boolean[rowSize][colSize];
        for(int i=0; i<rowSize;i++){
            for(int j=0; j<colSize; j++){
                if(grid[i][j] == '*'){
                    startLocation = new int[]{i,j};
                    visited[i][j] = true;
                    break; 
                }
            }
        }
        //2. Now traverse in all 4 directions from start location and find food
        int[] rowTravel = new int[]{-1,1,0,0};
        int[] colTravel = new int[]{0,0,-1,1};
        int pathSize = 0;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(startLocation);
        
        while(!queue.isEmpty()){
            int currentLevel = queue.size();
            pathSize++;
            for(int k=0; k<currentLevel; k++){
                int[] curr = queue.poll();
                int currRow = curr[0], currCol = curr[1];
                for (int i = 0; i < rowTravel.length; i++) {
                    int newRow = currRow + rowTravel[i];
                    int newCol = currCol + colTravel[i];
                    if(newRow >=0 && newRow < rowSize && newCol >= 0 && newCol < colSize && 
                        grid[newRow][newCol]!= 'X' && !visited[newRow][newCol]){
                        if(grid[newRow][newCol] == '#') return pathSize;
                        else{
                            visited[newRow][newCol] = true;
                            queue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
            }
        }
        return -1;
    }
}