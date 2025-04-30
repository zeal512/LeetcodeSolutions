class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magzineLetter = new HashMap<>();
        for(char ch : magazine.toCharArray()){
            magzineLetter.put(ch, magzineLetter.getOrDefault(ch, 0) + 1);
        }
        for(char c : ransomNote.toCharArray()){
            if (!magzineLetter.containsKey(c) || magzineLetter.get(c) <=0) return false;
            
            magzineLetter.put(c, magzineLetter.get(c) -1 );
        }
        return true;
    }
}