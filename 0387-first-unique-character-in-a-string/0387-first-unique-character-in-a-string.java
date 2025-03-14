class Solution {
    public int firstUniqChar(String s) {
        if(s.length() == 1) return 0;
        int arrSize = 26;
        int[] arr = new int[arrSize];
        Arrays.fill(arr, 0);
        
        for(int i=0; i< s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }

        for(int i=0; i< s.length(); i++){
            if(arr[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;
    }
}