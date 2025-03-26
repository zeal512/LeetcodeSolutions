class Solution {
    public char repeatedCharacter(String s) {
        boolean[] charArr = new boolean[26];
        for(char ch: s.toCharArray()){
            int index = ch - 'a';
            if(charArr[index]) return ch;
            charArr[index] = true;
        }
        return 'a';
    }
}