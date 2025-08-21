class Solution {
    public char findTheDifference(String s, String t) {
        int bit = 0;
        for (int i = 0; i < t.length(); i++) {
            if (i < s.length()) {
                bit ^=s.charAt(i);
            }
            bit^=t.charAt(i);
        }
        return (char) bit;
    }
}