class SparseVector {
    List<int[]> index_num_mapping = new ArrayList<>();
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) index_num_mapping.add(new int[]{i,nums[i]});
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int i=0, j=0, sum=0;
        while (i < index_num_mapping.size()  && j < vec.index_num_mapping.size()) {
            if (index_num_mapping.get(i)[0] < vec.index_num_mapping.get(j)[0]) i++;
            else if (index_num_mapping.get(i)[0] > vec.index_num_mapping.get(j)[0]) j++;
            else{
                sum += index_num_mapping.get(i)[1] * vec.index_num_mapping.get(j)[1]; 
                i++;
                j++;
            }
        }
        return sum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);