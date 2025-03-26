class Solution {
    public int majorityElement(int[] nums) {
        int var = 0;
        int count =0;
        for(int i=0; i<nums.length; i++){
            if(count == 0){
                var = nums[i];
                count+=1;
            }
            else if(var == nums[i]){
                count++;
            }
            else{
                count--;
            }
        }
        // if(count == 0) return -1;
        return var;
        // int counter=0;
        // for(int i=0; i<nums.length; i++){
        //     if(nums[i] == var) counter++;
        // }

        // if(counter > nums.length/2) return var;
        // return -1;
    }
}