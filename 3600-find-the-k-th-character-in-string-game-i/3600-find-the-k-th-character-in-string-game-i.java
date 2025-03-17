class Solution {
    public char kthCharacter(int k) {
        String result = generateString(k, "a");
        System.out.println(result);
        return result.charAt(k-1);
    }

    public static String generateString(int k, String prev){
        if(prev.length() > k) return prev;
        String newStr = ""; 
        for(int i=0; i< prev.length(); i++){
            newStr = newStr + (char) (prev.charAt(i) + 1); 
        }
        return generateString(k, prev + newStr);
        
    }

}