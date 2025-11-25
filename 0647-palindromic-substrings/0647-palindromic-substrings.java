class Solution {
    public int countSubstrings(String s) {
        int count =0;
        for(int i=0; i< s.length(); i++){
            count+= isPalindromic(s,i,i);
            count+= isPalindromic(s,i,i+1);
        }
        return count;
        
    }

    public static int isPalindromic(String s,int left, int right){
        int count =0;
        while (left >=0 && right < s.length() && s.charAt(left)== s.charAt(right)) {
            left-=1;
            right+=1;
            count+=1;
        }
        return count;
    }
    
}