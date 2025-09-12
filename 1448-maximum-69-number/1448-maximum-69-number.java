class Solution {
    public int maximum69Number (int num) {
        StringBuilder builder = new StringBuilder();
        String number = String.valueOf(num);
        boolean flag = true;
        for(char ch:number.toCharArray()){
            if (ch == '6' && flag) {
                builder.append('9');
                flag = false;
            }else{
                builder.append(ch);
            }
        }
        return Integer.parseInt(builder.toString());
    }
}