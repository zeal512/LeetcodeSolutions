class Solution {
    public boolean validPalindrome(String s) {
        int left =0, right = s.length()-1;
        if(s.length() == 1 ){
            return true;
        }
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return (isSubstringPalindrome(s, left + 1, right) ||
                        isSubstringPalindrome(s, left, right-1));
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean isSubstringPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}