class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> list = new ArrayList<>();
        for(int i = 0; i< m; i++){
            boolean isArithmatic = true;
            int start = l[i];
            int end = r[i];
            int[] arr = new int[end - start+1];
            int arrCtr = 0;
            for(int k=start; k<=end; k++){
                arr[arrCtr] = nums[k];
                arrCtr++;
            }
            Arrays.sort(arr);
            int diff = arr[1] - arr[0];
            for(int j=1; j< arr.length; j++){
                if(arr[j] - arr[j-1] != diff){
                    isArithmatic = false;
                }
            }
            list.add(isArithmatic);
        }
        return list;
    }
}