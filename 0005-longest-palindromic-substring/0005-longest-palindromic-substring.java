class Solution {
    public String longestPalindrome(String s) {
        if(s.length() <=1) return s;
        String result = "";
        for(int i=0; i< s.length(); i++){
            String right = checkPalindrome(i, i, s);
            String left = checkPalindrome(i, i+1, s);
            if(left.length() >= right.length() && left.length() > result.length()){
                result = left;
            }
            else if(right.length() > result.length()) result = right;
        }
        return result;
    }
    public static String checkPalindrome(int left, int right, String s){
        while(left >=0 && right <s.length()){
            if(s.charAt(left)!= s.charAt(right)) break;
            left-=1;
            right+=1;
        }
        return s.substring(left+1, right);
    }
}