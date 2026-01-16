class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();//3,5
        int currNum = 0;
        int currOperator = '+';
        int len = s.length();
        for(int i=0; i< len; i++){
            char currChar = s.charAt(i);
            if(Character.isDigit(currChar)){
                currNum = (currNum * 10) + currChar-'0';
            }
            if(!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == len -1 ){
                if(currOperator == '+'){
                    stack.push(currNum);
                }
                else if(currOperator == '-'){
                    stack.push(-currNum);
                }
                else if(currOperator == '*'){
                    stack.push(stack.pop() * currNum);
                }
                else if(currOperator == '/'){
                    stack.push((int)( stack.pop() / currNum));
                }
                currOperator = currChar;
                currNum = 0;
            }
        }
        int result =0;
        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}