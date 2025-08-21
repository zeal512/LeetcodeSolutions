class Solution {
    public char findTheDifference(String s, String t) {
        if (s.length() == 0) return t.charAt(0);
        int bit = 0;
        for (Character ch : s.toCharArray()) {
            bit = bit ^ ch;
        }
        for (Character ch : t.toCharArray()) {
            bit = bit ^ ch;
        }
        return (char) bit;
    }
}