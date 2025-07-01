class Solution {
    public String convert(String s, int numRows) {
        if(numRows > s.length() || numRows == 1) return s;
        List<List<Character>> build = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            build.add(new ArrayList<>());
        }

        int index = 0, direction = 1;
        for(char ch: s.toCharArray()){
            build.get(index).add(ch);
            if (index == 0) {
                direction = 1;
            }
            else if(index == numRows-1){
                direction = -1;
            }
            index += direction;
        }
        StringBuilder builder = new StringBuilder();

        for(List<Character> l : build ){
            for(char c: l){
                builder.append(c);
            }
        }
        return builder.toString();
    }
}