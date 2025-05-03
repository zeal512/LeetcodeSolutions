class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if(words.size() != s.length()) return false;
        StringBuilder wordFormed = new StringBuilder();
        for(String word : words){
            wordFormed.append(word.charAt(0));
        }
        if(wordFormed.toString().equals(s)) return true;
        return false;
    }
}