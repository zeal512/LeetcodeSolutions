class Solution {
    public int removeDuplicates(int[] nums) {
        int i =1, count =1;
        for(int j =1; j < nums.length; j++){
            if(nums[j-1] == nums[j]){
                count+=1;
            }
            else count =1;
            if(count <=2){
                nums[i] = nums[j];
                i+=1;
            }
        }
        return i;
    }
}
/*
k = 6,5 
[1,1,1,2,2,3]
           ij

*/