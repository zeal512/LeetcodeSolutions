class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int finalSum = 0, operation = 1, num = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                num = (num * 10) + currChar - '0';
            }
            else if(currChar == '+'){
                finalSum +=(num * operation);
                num = 0;
                operation = 1;
            }
            else if(currChar == '-'){
                finalSum +=(num * operation);
                num = 0;
                operation = -1;
            }
            else if(currChar == '('){
                stack.push(finalSum);
                stack.push(operation);
                finalSum = 0;
                operation = 1;
            }
            else if(currChar == ')'){
                finalSum += (num * operation);
                num = 0;
                finalSum = finalSum * stack.pop();
                finalSum += stack.pop();
            }
        }
        if(num != 0) finalSum += (num * operation);
        return finalSum;
    }
}