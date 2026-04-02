class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1, lMax = 0, rMax = 0, total = 0;
        while(left < right){
            if(height[left] <= height[right]){
                if(height[left] < lMax){
                    total += lMax - height[left];
                }
                else{
                    lMax = height[left];
                }
                left++;
            }
            else{
                if(height[right] < rMax){
                    total += rMax - height[right];
                }
                else{
                    rMax = height[right];
                }
                right--;
            }
        }
        return total;
    }
}

//[0,1,0,2,1,0,1,3,2,1,2,1,0,1,2]

/* 
stack -> [2,1,2,1,0,1,2]

currMax - 3
(newMax - currMax) * sizeOfStack => (2-1)*1 = 1
trapped - 1
 */


//[4,2,0,3,2,5,1,0,2,3,4,1,0,2,1,3]