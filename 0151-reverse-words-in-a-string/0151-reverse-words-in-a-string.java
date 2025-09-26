class Solution {
    public String reverseWords(String s) {
        StringBuilder finalString = new StringBuilder();
        int ptr1 = s.length()-1;
        while (ptr1 >= 0) {
            StringBuilder builder = new StringBuilder();
            while (ptr1 >=0 && s.charAt(ptr1) == ' ') {
                ptr1--;
            }
            while(ptr1 >=0 && s.charAt(ptr1) != ' '){
                builder.append(s.charAt(ptr1));
                ptr1--;
            }
            builder.reverse();
            finalString.append(builder.toString());
            finalString.append(" ");
            ptr1--;
        }
        return finalString.toString().trim() ;
    }
}