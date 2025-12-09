class Solution {
    public int countTriples(int n) {
        int count =0;
        for(int m=2; (m*m)+1 <= n; m++){
            for(int k = 1; k<m; k++){
                if(gcd(m,k) == 1 && (m-k)%2 == 1){
                    int square = (m*m) + (k*k);
                    if(square > n) break;
                    count+= 2* (n/square);
                }
            }
        }
        return count;
    }
    public static int gcd(int num1, int num2){
        while(num2 > 0){
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    
}