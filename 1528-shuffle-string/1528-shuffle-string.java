class Solution {
    public String restoreString(String s, int[] indices) {
        int n = indices.length;
        if(n == 0) return new String();
        char[] shuffeled = new char[n];
        int i =0;
        for(int idx : indices){
            shuffeled[idx] = s.charAt(i++);
        }
        StringBuffer sb = new StringBuffer();
        for(char ch: shuffeled){
            sb.append(ch);
        }
        return sb.toString();
    }
}