class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0, minSum = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i+1, right = nums.length-1;
            while(left < right){
                sum = nums[i] + nums[left] + nums[right];
                if(sum == target) return sum;
                if(Math.abs(target - sum) < Math.abs(minSum)){
                    minSum = target - sum;
                }
                if(sum < target) left+=1;
                else right-=1;
            }
        }
        return target - minSum;      
    }
}

/* 
[-1,2,1,-4]

[-4,-1,1,2] <- sorted
[-4,-5,-4,-2]

*/