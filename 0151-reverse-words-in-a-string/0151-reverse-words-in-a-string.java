class Solution {
    public String reverseWords(String s) {
        int n = s.length() - 1;
        StringBuilder finalString = new StringBuilder(n);
        int ptr1 = n, ptr2 = n;
        char[] charArr = s.toCharArray();
        while (ptr1 >= 0) {

            while (ptr1 >= 0 && charArr[ptr1] == ' ') {
                ptr1--;
            }
            ptr2 = ptr1;
            while (ptr1 >= 0 && charArr[ptr1] != ' ') {
                ptr1--;
            }
            if (finalString.length() > 0) {
                finalString.append(' ');
            }
            finalString.append(charArr, ptr1 + 1, ptr2 - ptr1);
        }
        return finalString.toString().trim();
    }
    /* 

    - In the below solution (Using 2 StringBuilder()),
     every word required a fresh StringBuilder + .reverse() call.
    - For a string with k words, I did k allocations and k reversals.
    - In the two-pointer solution, 
    I append substrings directly — no per-word object creation, no per-word reversal

    public String reverseWords(String s) { 
        StringBuilder finalString = new StringBuilder(); 
        int ptr1 = s.length()-1; 
        while (ptr1 >= 0) { 
            StringBuilder builder = new StringBuilder(); 
            while (ptr1 >=0 && s.charAt(ptr1) == ' ') 
            { ptr1--; }
             while(ptr1 >=0 && s.charAt(ptr1) != ' ')
             { 
                builder.append(s.charAt(ptr1)); ptr1--; 
            }
            builder.reverse(); 
            finalString.append(builder.toString()); 
            finalString.append(" "); ptr1--; 
            } 
            return finalString.toString().trim() ; 
            }*/
}