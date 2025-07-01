class Solution {
    public int possibleStringCount(String word) {
        int possibilities = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i-1) ) {
                possibilities++;
            }
        }
        return possibilities;
    }
}