class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        String[] directory = path.split("/");
        for(String dir: directory){
            if(dir.equals("") || dir.equals(".")  ){
                continue;
            }
            if(dir.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }
            else{
                stack.push(dir);
            }
        }
        if(stack.isEmpty()) return "/";
        
        for (String str: stack) {
            result.append("/").append(str);
        }
        return result.toString();
    }
}