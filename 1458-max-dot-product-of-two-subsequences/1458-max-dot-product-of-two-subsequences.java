class Solution {
    int[][] arr;
    public int performDP(int i, int j, int[] nums1, int[] nums2){
        
        if(i == nums1.length || j == nums2.length) return 0;
       
        if(arr[i][j] != 0) return arr[i][j];
        
        int dotProd = (nums1[i] * nums2[j]) + performDP(i+1, j+1, nums1, nums2);
        
        arr[i][j] = Math.max(dotProd, Math.max( performDP(i+1,j,nums1,nums2) , performDP(i,j+1,nums1,nums2)));
        return arr[i][j];
    }
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int nums1Max = Integer.MIN_VALUE;
        int nums1Min = Integer.MAX_VALUE;
        int nums2Max = Integer.MIN_VALUE;
        int nums2Min = Integer.MAX_VALUE;
        
        for(int num : nums1){
            nums1Max = Math.max(nums1Max, num);
            nums1Min = Math.min(nums1Min, num);
        }

        for(int num : nums2){
            nums2Max = Math.max(nums2Max, num);
            nums2Min = Math.min(nums2Min, num);
        }

        if(nums1Max < 0 && nums2Min > 0) return nums1Max * nums2Min;
        if(nums1Min > 0 && nums2Max < 0) return nums1Min * nums2Max;
        
        arr = new int[nums1.length][nums2.length];
        return performDP(0, 0, nums1, nums2);
    }
}