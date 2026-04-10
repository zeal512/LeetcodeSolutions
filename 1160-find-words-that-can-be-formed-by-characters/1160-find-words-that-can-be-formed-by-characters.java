class Solution {
    public int countCharacters(String[] words, String chars) {
        int sumOfStrings = 0;
        Map<Character, Integer> dict = new HashMap<>();
        for(char ch: chars.toCharArray()){
            dict.put(ch, dict.getOrDefault(ch,0)+1);
        }
        for(String word : words){
            boolean canBeFormed = true;
            Map<Character, Integer> temp = new HashMap<>(dict);
            for(char ch: word.toCharArray()){
                if(temp.containsKey(ch) && temp.get(ch) > 0){
                    temp.put(ch, temp.get(ch)-1);
                }
                else{
                    canBeFormed = false;
                    break;
                }
            }
            if(canBeFormed) sumOfStrings+= word.length();
        }
        return sumOfStrings;
    }
}