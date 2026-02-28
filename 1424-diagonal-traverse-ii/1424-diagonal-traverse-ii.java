class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        /* int size = 0, maxCol = 0, maxRow = nums.size();
        
        for(List<Integer> list : nums){
            maxCol = Math.max(maxCol, list.size());
            size+=list.size();
        }

        int[][] newNums = new int[maxRow][maxCol];
        
        
        int r = 0;
        for(List<Integer> num : nums){
            int j = 0;
            for(int numb : num){
                newNums[r][j++] =  numb;;
            }
            r++;
        }

        int[] ans = new int[size];
        int ptr = 0;
        for(int i = 0; i < maxRow; i++){
            int cr = i, cc = 0;
            while(cr >=0 && cc < maxCol){
                if(newNums[cr][cc] != 0) ans[ptr++] = newNums[cr][cc];
                cr--;
                cc++;
            }
        }
        for(int j = 1; j < maxCol; j++){
            int cr = maxRow-1, cc = j;
            while(cc >=0 && cc < maxCol && cr >= 0){
                if(newNums[cr][cc] != 0) ans[ptr++] = newNums[cr][cc];
                cr--; 
                cc++;
            }
        }
        return ans; */



        /* The above logic is correct but we get error when input size increases. 

        Error - Memory Limit Exceeded 
        
        So, we can add the row+col index, and for a diagonal, sum or row and col index of any cell in that diagonal is equal.
        eg. ({1,0} and {0,1})
        */
        
        
        //Approach Using HashMap, using row and col and finding index hash and using it as diagonal. 
        
        
        /* Map<Integer, List<Integer>> diagonals = new HashMap<>();
        int total = 0;
        for(int r = nums.size()-1; r >= 0; r--){
            for(int c =0; c< nums.get(r).size(); c++){
                int indexHash = r + c;
                if(!diagonals.containsKey(indexHash)){
                    diagonals.put(indexHash, new ArrayList<>());
                }
                diagonals.get(indexHash).add(nums.get(r).get(c));
                total++;
            }
        }
        int[] ans = new int[total];
        int ptr = 0, current = 0;
        while (diagonals.containsKey(current)) {
            for(int num : diagonals.get(current)){
                ans[ptr++] = num;
            }
            current+=1;
        }
        return ans; */


        // Using BFS technique

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        List<Integer> list = new ArrayList<>();

        while(!queue.isEmpty()) {
            Pair<Integer, Integer> curr = queue.poll();
            int row = curr.getKey();
            int col = curr.getValue();
            list.add(nums.get(row).get(col));
            if(col == 0 && row + 1 < nums.size()){
                queue.offer(new Pair(row+1, col));
            }
            if(col + 1 < nums.get(row).size()){
                queue.offer(new Pair(row, col+1));
            }
        }
        int[] ans = new int[list.size()];
        for(int i =0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}