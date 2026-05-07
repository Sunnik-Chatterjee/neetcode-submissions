class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int i = 0,j=i+1;
        while(j<prices.length){
            if(prices[i]<prices[j]){
                int profit = prices[j]-prices[i];
                maxProfit = Math.max(profit,maxProfit);
            }else{
                i=j;
            }
            j++;
        }
        return maxProfit;
    }
}
