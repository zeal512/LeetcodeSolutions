class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        
        int startRow = 0, endRow = matrix.length-1, startCol = 0, endCol = matrix[0].length-1;
        
        while(startRow <= endRow && startCol <= endCol){
            
            for(int j= startCol; j<= endCol; j++ ){
                list.add(matrix[startRow][j]);
            }
            startRow++;
            if(startRow > endRow) break;

            for(int i = startRow; i <= endRow; i++){
                list.add(matrix[i][endCol]);
            }
            endCol--;
            if(startCol > endCol) break;

            for(int j= endCol; j >= startCol; j-- ){
                list.add(matrix[endRow][j]);
            }
            endRow--;
            if(startRow > endRow) break;

            for(int i = endRow; i >= startRow; i--){
                list.add(matrix[i][startCol]);
            }
            startCol++;
        }
            /* while( j <= endCol ){
                if(startRow == endRow && j == endCol){
                    System.out.println(startCol + ", "+endCol);
                    list.add(matrix[i][j]);
                    return list;
                }
                list.add(matrix[i][j++]);
            }
            j = endCol;
            i++;
            
            while(i <= endRow){
                if(startRow == endRow && j == endCol){
                    System.out.println(startCol + ", "+endCol);
                    list.add(matrix[i][j]);
                    return list;
                }
                list.add(matrix[i++][j]);
            }
            i = endRow;
            j--;
            
            while( j >= startCol){
                if(startRow == endRow && j == endCol){
                    System.out.println(startCol + ", "+endCol);
                    list.add(matrix[i][j]);
                    return list;
                }
                list.add(matrix[i][j--]);
            }
            j = startCol;
            i--;

            while ( i > startRow){
                if(i == midRow && j == midCol){
                    System.out.println(startCol + ", "+endCol);
                    list.add(matrix[i][j]);
                    return list;
                }
                list.add(matrix[i--][j]);
            }
            System.out.println(list);
            startRow+=1; 
            endRow-=1;
            startCol+=1;
            endCol-=1;
        } */
        return list;
    }
}


/* [1,2]
rows = 3, cols = 4
mid = (1,2)

 */