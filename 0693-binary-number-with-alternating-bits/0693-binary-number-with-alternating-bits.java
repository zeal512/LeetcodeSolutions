class Solution {
    public boolean hasAlternatingBits(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int reminder = n % 2;
            builder.append(reminder);
            n/=2;
        }
        String binary = builder.reverse().toString();
        for (int i =1; i< binary.length(); i++) {
            if(binary.charAt(i-1) == binary.charAt(i)) return false;
        }
        return true;
    }
}