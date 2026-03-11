class Solution {
    public int[] nextGreaterElements(int[] nums) {
        /* int n = nums.length;
        int[] result = new int[n];
        for(int i=0; i< n; i++){
            int j = (i+1)%n;
            while (j != i) {
                if(nums[j] > nums[i]){
                    result[i] = nums[j];
                    break;
                }
                j = (j+1)%n;
            }
            if(j == i) result[i] = -1;
        }
        return result; */
        int numSize = nums.length;
        int n = (numSize * 2)-1;
        
        int[] result = new int[numSize];

        Stack<Integer> stack = new Stack<>();
        for(int i = n; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= nums[i % numSize]){
                stack.pop();
            }
            if(i < numSize){
                result[i] = stack.isEmpty()? -1 : stack.peek();
            }
            stack.push(nums[i%numSize]);
        }
        return result;
    }
}