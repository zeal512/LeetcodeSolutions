class Solution {
    public int equalPairs(int[][] grid) {
        int size = grid.length;
        int equalCount = 0;
        Map<String, Integer> rows = new HashMap<>();
        for (int i = 0; i < size; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < size; j++) {
                builder.append(grid[i][j]).append(",");                
            }   
            rows.put(builder.toString(), rows.getOrDefault(builder.toString(), 0) +1 );
        }
        
        for (int i = 0; i < size; i++) {
            StringBuilder colBuilder = new StringBuilder();
            for (int j = 0; j < size; j++) {
                colBuilder.append(grid[j][i]).append(",");                
            }
            if(rows.get(colBuilder.toString()) != null){
                equalCount += rows.get(colBuilder.toString());
            }
        }
        return equalCount;
    }
}