class Solution {
    public char findTheDifference(String s, String t) {
        
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