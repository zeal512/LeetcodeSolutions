class Solution {
    public String makeFancyString(String s) {
        if(s.length() < 3) return s;
        StringBuilder newString = new StringBuilder();
        int count =1;
        for (int i = 0; i < s.length(); i++) {
            if( i > 0 && s.charAt(i) == s.charAt(i-1)){
                count+=1;
            }
            else{
                count = 1;
            }
            if (count < 3) {
                newString.append(s.charAt(i));
            }
        }

        return newString.toString();
    }
}