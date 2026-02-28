class Solution {
    public int[][] diagonalSort(int[][] mat) {
        Map<Integer, Queue<Integer>> diagonals = new HashMap<>();
        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat[0].length; col++){
                int cellIndex = row - col;
                if(!diagonals.containsKey(cellIndex)){
                    diagonals.put(cellIndex, new PriorityQueue<>());
                }
                diagonals.get(cellIndex).add(mat[row][col]);
            }
        }
        
        for(int row = 0; row < mat.length; row++){
            for(int col = 0; col < mat[0].length; col++){
                mat[row][col] = diagonals.get(row-col).remove();
            }
        }
        return mat;
    }
}