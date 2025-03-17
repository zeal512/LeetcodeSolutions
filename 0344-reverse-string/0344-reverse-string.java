class Solution {
    public void reverseString(char[] s) {
        if(s.length == 0){
            return;
        }
        int start = 0, end = s.length-1;
        char c ;
        while(start<=end){
            c = s[start];
            s[start] = s[end];
            s[end] = c;
            start++;
            end--;
        }
    }
}