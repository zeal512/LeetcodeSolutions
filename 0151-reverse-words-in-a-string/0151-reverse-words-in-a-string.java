class Solution {
    public String reverseWords(String s) {
        int n = s.length()-1;
        StringBuilder finalString = new StringBuilder(n);
        int ptr1 =n, ptr2 = n;
        char[] charArr = s.toCharArray();
        while (ptr1 >= 0) {
            
            while (ptr1 >=0 && charArr[ptr1] == ' ') {
                ptr1--;
            }
            ptr2 = ptr1;
            while(ptr1 >=0 && charArr[ptr1] != ' '){
                ptr1--;
            }
            if (finalString.length() > 0) {
                finalString.append(' ');
            }
            finalString.append(charArr, ptr1+1, ptr2 - ptr1);
        }
        return finalString.toString().trim() ;
    }
}