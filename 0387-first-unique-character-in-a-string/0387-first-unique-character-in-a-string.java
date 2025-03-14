class Solution {
    public int firstUniqChar(String s) {
        if(s.length() == 1) return 0;
        int arrSize = 26;
        int[] arr = new int[arrSize];
        Arrays.fill(arr, -1);
        int minVal = Integer.MAX_VALUE;
        
        for(int i=0; i< s.length(); i++){
            if(arr[s.charAt(i) - 'a'] == -1){
                arr[s.charAt(i) - 'a'] = i;
            }
            else arr[s.charAt(i) - 'a'] = -2;
        }

        for(int i=0; i< arrSize; i++){
            if(arr[i] != -1 && arr[i] != -2) minVal = Math.min(minVal, arr[i]);
        }
        if(minVal != Integer.MAX_VALUE) return minVal;
        return -1;
    }
}