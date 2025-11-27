class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = 0;
        total+=numBottles;
        while(numBottles >= numExchange){
            total += numBottles/numExchange;
            numBottles = (numBottles/numExchange) + (numBottles % numExchange);
        }
        return total;
    }
}
