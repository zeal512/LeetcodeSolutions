class Solution {
    public int numberOfBeams(String[] bank) {
        int sum = 0, prev = 0, row = bank.length;
        for(int i=0; i< row; i++){
            int current = 0;
            for(char ch: bank[i].toCharArray()){
                if(ch == '1') current++;
            }
            if(current == 0) continue;
            sum += prev * current;
            prev = current;
        }
        return sum;
    }
}