class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = 0;
        total+=numBottles;
        while(numBottles >= numExchange){
            System.out.println(total);
            total += numBottles/numExchange;
            
            numBottles = (numBottles/numExchange) + (numBottles % numExchange);
        }
        return total;
    }
}
/* 
numBottles = 9 , (9/3) + (9%3) = 3, 1
numExchange = 3
total = 9 , (9+3) = 12, 13







 */
