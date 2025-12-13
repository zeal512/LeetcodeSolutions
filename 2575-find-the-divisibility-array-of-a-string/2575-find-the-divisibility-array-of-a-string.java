class Solution {
    public int[] divisibilityArray(String word, int m) {
        int n = word.length();
        /* StringBuilder num = new StringBuilder();
        int[] divisibilityArr = new int[n];
        Arrays.fill(divisibilityArr, 0);
        for(int i=0; i<n; i++){
            num.append(word.charAt(i));
            long checkNum = Integer.parseInt(num.toString());
            if(checkNum % m == 0) divisibilityArr[i] = 1;
        }
        return divisibilityArr; */
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