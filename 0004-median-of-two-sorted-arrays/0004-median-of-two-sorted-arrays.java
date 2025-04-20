class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int ptr1 = 0, ptr2 = 0, size1 = nums1.length, size2 = nums2.length;
        int[] mergedArray = new int[size1 + size2];
        int i=0;
        double median = 0;
        while (ptr1 < size1 && ptr2 < size2) {
            if( nums1[ptr1] <= nums2[ptr2] ){
                mergedArray[i] = nums1[ptr1];
                i++;
                ptr1++;
            }
            else{
                mergedArray[i] = nums2[ptr2];
                i++;
                ptr2++;
            }
        }
        while (ptr1 < size1 ) {
            mergedArray[i] = nums1[ptr1];
            i++;
            ptr1++;
        }
        while (ptr2 < size2) {
            mergedArray[i] = nums2[ptr2];
            i++;
            ptr2++;
        }
        
        if(mergedArray.length % 2 == 0){
            int right = mergedArray.length /2;
            int left = right -1;
            median = (mergedArray[left] + mergedArray[right]) / 2.0 ;
        }
        else{
            median = mergedArray[(mergedArray.length)/2];
        }

        return median;
    }
}