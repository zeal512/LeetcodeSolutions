class Solution {
    public int maxProfit(int[] prices) {
        /* int profit = 0;
        for(int i=0; i< prices.length-1; i++){
            for(int j = i+1; j< prices.length; j++){
                profit = Math.max(profit, prices[j] - prices[i]);
            }
        }
        return profit; */
        int minPrice = Integer.MAX_VALUE, profit = 0;
        for(int i =0; i< prices.length; i++){
            if(minPrice > prices[i]){
                minPrice = prices[i];
            }else if(prices[i] > minPrice ){
                profit = Math.max(profit, prices[i] - minPrice);
            }
        }
        return profit;
    }
}