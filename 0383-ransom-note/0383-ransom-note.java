class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for(char ch : magazine.toCharArray()){
            letters[ch - 'a'] +=1; 
        }
        for(char c : ransomNote.toCharArray()){
            if(letters[c - 'a'] <=0 ) return false;
            letters[c - 'a'] -=1;
        }
        return true;
    }
}