class Solution {
    public int equalPairs(int[][] grid) {
        int size = grid.length;
        int equalCount = 0;
        Map<List<Integer>, Integer> rows = new HashMap<>();
        for (int i = 0; i < size; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                list.add(grid[i][j]);
            }   
            rows.put(list, rows.getOrDefault(list, 0)+1);
        }
        
        for (int i = 0; i < size; i++) {
            List<Integer> colList = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                colList.add(grid[j][i]);
            }
            if (rows.get(colList) != null) {
                equalCount += rows.get(colList);
            }
        }
        return equalCount;
    }
}