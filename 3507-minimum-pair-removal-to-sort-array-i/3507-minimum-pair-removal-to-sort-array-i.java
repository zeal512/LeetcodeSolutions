class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for(int num : nums) list.add(num);
        while (list.size() > 1) {
            
            int minSum = Integer.MAX_VALUE;
            boolean isAscendingOrder = true;
            int replacingIndex = -1;

            for(int i =0 ; i< list.size()-1; i++){
                int currSum = list.get(i) + list.get(i+1);
                
                if(list.get(i + 1) < list.get(i)){
                    isAscendingOrder = false;
                }
                if(currSum < minSum){
                    minSum = currSum;
                    replacingIndex = i;
                }
            }
            if(isAscendingOrder) return count;
            count+=1;
            list.set(replacingIndex, minSum);
            list.remove(replacingIndex+1);
        }
        return count;
    }
}

/* 
if already sorted(non-decreasing), return 0

brute force, 

1. check for pair with minimum sum
    replace the 2 numbers with sum, increase the count by 1 and check if it is in non-decreasing
    if not, perform step 1 again

[5,2,3,1]




*/