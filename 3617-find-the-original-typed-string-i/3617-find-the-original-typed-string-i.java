class Solution {
    public int possibleStringCount(String word) {
        //Map<Character, Integer> countChar = new HashMap<>();
        int possibilities = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i-1) ) {
                possibilities++;
            }
        }
        return possibilities;
        /* for(char ch: word.toCharArray()){
            countChar.put(ch, countChar.getOrDefault(ch, 0) + 1);
        }
        for(int value : countChar.values()){
            if(value > 1){
                possibilities += (value - 1);
            }
        }
        return possibilities; */
    }
}