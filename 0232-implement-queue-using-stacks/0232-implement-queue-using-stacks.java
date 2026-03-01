class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    /* 
    [1]
    [4,3,2] 
    */
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        int popVal = stack1.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return popVal;
    }
    
    public int peek() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }
        int peekVal = stack1.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return peekVal;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */