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
                    builder.append(stack.pop());
                }
                builder.reverse();
                stack.pop();
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek()) ) {
                    num.append(stack.pop());
                }
                num.reverse();
                String newString = builder.toString().repeat(Integer.parseInt(num.toString()) );
                for (Character character : newString.toCharArray()) {
                    stack.push(character);
                }
                /* stack.push(builder.toString().repeat(Integer.parseInt(num.toString()) )); */
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}