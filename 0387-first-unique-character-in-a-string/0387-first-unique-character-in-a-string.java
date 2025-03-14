class Solution {
    public int firstUniqChar(String s) {
        if(s.length() == 1) return 0;
        int arrSize = 26;
        int[] arr = new int[arrSize];
        Arrays.fill(arr, 0);
        //int minVal = Integer.MAX_VALUE;
        
        for(int i=0; i< s.length(); i++){
            // if(arr[s.charAt(i) - 'a'] == -1){
            //     arr[s.charAt(i) - 'a'] = i;
            // }
            // else arr[s.charAt(i) - 'a'] = -2;
            arr[s.charAt(i) - 'a']++;
        }

        for(int i=0; i< s.length(); i++){
            //if(arr[i] >=0) minVal = Math.min(minVal, arr[i]);
            if(arr[s.charAt(i) - 'a'] == 1) return i;
        }
        //return (minVal == Integer.MAX_VALUE) ? -1: minVal;
        return -1;
    }
}