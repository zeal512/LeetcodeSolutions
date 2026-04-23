class Solution {
    public String toGoatLatin(String sentence) {
        int aCounter = 1;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        StringBuilder answer = new StringBuilder();
        String[] words = sentence.split(" ");
        for(String word : words){
            if(vowels.contains( Character.toLowerCase(word.charAt(0)) )){
                answer.append(word);
            }
            else{
                char first = word.charAt(0);
                answer.append(word.substring(1));
                answer.append(first);
            }
            answer.append("ma");
            answer.append("a".repeat(aCounter++));
            answer.append(" ");
        }
        return answer.substring(0, answer.toString().length()-1);
    }
}