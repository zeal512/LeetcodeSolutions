class Solution {
    
    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<>();
        if(digits.length() == 0) return output;
        
        Map<Character, String> numCombination = new HashMap<>();
        numCombination.put('2', "abc");
        numCombination.put('3', "def");
        numCombination.put('4', "ghi");
        numCombination.put('5', "jkl");
        numCombination.put('6', "mno");
        numCombination.put('7', "pqrs");
        numCombination.put('8', "tuv");
        numCombination.put('9', "wxyz");

        helper(0, numCombination, new StringBuilder(), digits, output);
        return output;
    }

    public static void helper(int index, Map<Character, String> numCombination, StringBuilder combination, String inputDigits, List<String> output){
        if (combination.length() == inputDigits.length()) {
            output.add(combination.toString());
            return;
        }
        String mappedCharacters = numCombination.get(inputDigits.charAt(index));
        for(char letter : mappedCharacters.toCharArray()){
            combination.append(letter);
            helper(index+1, numCombination, combination, inputDigits, output);
            combination.deleteCharAt(combination.length()-1);
        }
    }
}