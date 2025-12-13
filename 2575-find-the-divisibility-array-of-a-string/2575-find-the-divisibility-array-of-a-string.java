class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        int[] result = new int[n];
        Arrays.fill(result, 0);
        long num = 0;

        for(int i=0; i< word.length(); i++){
            num = num * 10 + (word.charAt(i) - '0');
            if(num%m ==0) result[i] = 1;
            num = num%m;
        }
        return result;
    }
}