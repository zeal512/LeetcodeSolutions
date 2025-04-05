class Solution {
    public boolean lemonadeChange(int[] bills) {
        int total5bills = 0, total10bills = 0, total20bills = 0;
        for(int i=0; i< bills.length; i++){
            if(bills[i] == 5){
                total5bills++;
            }
            else if(bills[i] == 10 && total5bills > 0){
                total10bills++;
                total5bills--;
            }
            else if((bills[i] == 20 && total5bills >= 3) || 
                    (bills[i] == 20 && total5bills > 0 && total10bills > 0) ) {
                total20bills++;
                if(total10bills == 0 && total5bills >= 3){
                    total5bills = total5bills - 3;    
                }
                else{
                    total5bills--;
                    total10bills--;
                }
            }else{
                return false;
            }
        }
        return true;
    }
}