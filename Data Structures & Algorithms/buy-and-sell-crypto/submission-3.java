class Solution {
    public int maxProfit(int[] prices) {
        int i = 0, j = 0;
        int maxProfit = 0; 
        for(i=0;i<prices.length;i++){
            if(prices[j]>prices[i]){
                j = i;
            }
            int profit = prices[i]-prices[j];
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}
