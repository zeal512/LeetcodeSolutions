class Solution {
    public String convert(String s, int numRows) {
        if(numRows > s.length() || numRows == 1) return s;

        List<Character>[] zigzag = new ArrayList[numRows];
        for (int i = 0; i < numRows; i++) {
            zigzag[i] = new ArrayList<>();
        }
        int index = 0, direction = 1;
        for(char ch: s.toCharArray()){
            zigzag[index].add(ch);
            if (index == 0) {
                direction = 1;
            }
            else if(index == numRows-1){
                direction = -1;
            }
            index += direction;
        }
        StringBuilder builder = new StringBuilder();
        for(List<Character> list: zigzag){
            for(Character ch: list){
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}