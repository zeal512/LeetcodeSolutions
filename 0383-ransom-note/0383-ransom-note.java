class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //Map<Character, Integer> magzineLetter = new HashMap<>();
        int[] letters = new int[26];
        for(char ch : magazine.toCharArray()){
            letters[ch - 'a'] +=1; 
           // magzineLetter.put(ch, magzineLetter.getOrDefault(ch, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()){
            if(letters[c - 'a'] <=0 ) return false;
            letters[c - 'a'] -=1;
            /* if (!magzineLetter.containsKey(c) || magzineLetter.get(c) <=0) return false;
            magzineLetter.put(c, magzineLetter.get(c) -1 ); */
        }
        return true;
    }
}