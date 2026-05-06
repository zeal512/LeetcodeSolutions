class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int astroid : asteroids){
            
            if(astroid < 0 && !stack.isEmpty()){
                boolean bothAstroidsCollided = false;
                while(!stack.isEmpty()){
                    if(stack.peek() < 0){
                        stack.push(astroid);
                        break;
                    }
                    else if(Math.abs(astroid) == stack.peek()){
                        bothAstroidsCollided = true;
                        stack.pop();
                        break;
                    }
                    else if(Math.abs(astroid) > stack.peek()) stack.pop();
                    else break;
                }
                if(stack.isEmpty() && !bothAstroidsCollided) stack.push(astroid);
            }
            
            else stack.push(astroid);
        }
        if(stack.isEmpty()) return new int[0];
        int pointer = stack.size();
        int[] result = new int[pointer];
        for(int i = pointer-1; i >=0; i--){
            result[i] = stack.pop();
        }
        return result;
    }
}