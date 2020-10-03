/**
 * 
 * Time complexity O(n) - one pass
 * Space complexity O(1)
 */
class Solution {
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int max = 0;
        int n = prices.length;
        for(int i = 0 ;i < n; i++){
             if(prices[i] < minprice){
                 minprice = prices[i];
             }else if(prices[i]-minprice > max){
                 max = prices[i]-minprice;
             }
        }
        return max;
    }
}