class Solution {
    public String addBinary(String a, String b) {
        int lengthOfA = a.length()-1;
        int lengthOfB = b.length()-1;

        char[] charA = a.toCharArray();
        char[] charB = b.toCharArray();
        StringBuilder sb = new StringBuilder();
        int carry =0;
        while(lengthOfA >=0 || lengthOfB >=0 || carry != 0){
            int numA = lengthOfA >= 0 ? charA[lengthOfA] - '0' : 0;
            int numB = lengthOfB >= 0 ? charB[lengthOfB] - '0' : 0;
            int sum = numA + numB + carry;
            int num = sum%2;
            carry = sum/2;
            sb.append(num);
            lengthOfA--;
            lengthOfB--;
            
         }
         if(carry > 0) sb.append(carry);
         return sb.reverse().toString();
    }
}