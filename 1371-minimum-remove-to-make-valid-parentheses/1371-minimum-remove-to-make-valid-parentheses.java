class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder(s);

        for(int i=0; i<s.length(); i++){
            if(sb.charAt(i) == '('){
                stack.push(i);
            }
            else if(sb.charAt(i) == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    sb.setCharAt(i, '*');
                }
            }
        }
        while(!stack.isEmpty()){
            sb.setCharAt(stack.pop(), '*');
        }
        StringBuilder result = new StringBuilder();
        for(char ch: sb.toString().toCharArray()){
            if(ch != '*') result.append(ch);
        }
        return result.toString();
    }
}