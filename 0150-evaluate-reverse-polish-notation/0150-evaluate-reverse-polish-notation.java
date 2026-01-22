class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");

        for (String str : tokens) {
            if (set.contains(str)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                if (str.equals("+")) {
                    stack.push(num1 + num2);
                } else if (str.equals("-")) {
                    stack.push(num1 - num2);
                } else if (str.equals("*")) {
                    stack.push(num1 * num2);
                } else {
                    stack.push(num1 / num2);
                }
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.pop();
    }
}