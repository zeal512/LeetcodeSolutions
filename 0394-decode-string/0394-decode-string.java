class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i =0; i< s.length(); i++){
            if (s.charAt(i) != ']') {
                stack.push(s.charAt(i));
            }
            else{
                StringBuilder builder = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[') {
                    builder.insert(0, stack.pop());
                }
                
                stack.pop();
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek()) ) {
                    num.insert(0, stack.pop());
                }
                String newString = builder.toString().repeat(Integer.parseInt(num.toString()) );
                
                for (Character character : newString.toCharArray()) {
                    stack.push(character);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}