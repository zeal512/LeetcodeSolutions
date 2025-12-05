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
        
        for (String str : stack) {
            result.append("/").append(str);
        }
        return result.toString();
        
        /* int i = 0;

        while(i < path.length()) {
            while (i < path.length() && path.charAt(i) == '.') {
                builder.append(path.charAt(i));
                i+=1;
            }
            if(builder.length() > 0 && builder.toString().equals("..") && !stack.isEmpty() ){
                stack.pop();
            }else if(builder.length() > 0){
                stack.push(builder.toString());
            }

            builder.delete(0, builder.toString().length());
            
            
            while(path.charAt(i) != '/' && i < path.length() ){
                builder.append(path.charAt(i));
                i+=1;
            }
            if(builder.length() > 0){
                stack.push(builder.toString());
                builder.delete(0, builder.toString().length());
            }
        }
        System.out.println(stack);
        
        while(!stack.isEmpty()){
            result.append("/");
            result.append(stack.pop());
        }
        result.delete(result.toString().length()-1, result.toString().length()); 
        */
    }
}