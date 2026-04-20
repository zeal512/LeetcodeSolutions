class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        
        int[] preSum = new int[words.length];
        int[] ans = new int[queries.length];
        Arrays.fill(preSum,0);
        for(int i =0; i < words.length; i++){
            String word = words[i];
            char start = word.charAt(0), end = word.charAt(word.length()-1);
            if(vowels.contains(start) && vowels.contains(end)){
                preSum[i] = preSum[i == 0? 0:i-1] + 1;
            }else preSum[i] = i== 0 ? 0: preSum[i-1];
        }
        for(int i = 0; i < queries.length; i++){ 
            int l = queries[i][0], r = queries[i][1];
            if(l == r){
                if(vowels.contains(words[l].charAt(0)) && 
                    vowels.contains(words[l].charAt(words[l].length()-1))) ans[i] = 1;
                else ans[i] = 0;
            }
            else ans[i] = l == 0 ?  preSum[r] : preSum[r] - preSum[l-1];
        }
        return ans;
    }
}


/*  
["aba","bcb","ece","aa","e"]

[1,0,1,1,1]
[1,1,2,3,4]

*/