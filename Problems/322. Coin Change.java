/**
 * 
 * 
 *  Its related to unbounded knapsack problem.
 *  DP
 *  One way is to check min for all possible i and j in dp
 *  Other way is to just go on checking min by adding just one coin. -- preferred
 * 
 public class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
        for (int j = 0; j < coins.length; j++) {
            if (coins[j] <= i) {
            dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
 }
 * 
 */
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Set<Integer> cns = new HashSet();
        for(int c: coins){
            cns.add(c);
        }
        dp[0] = 0;
        for(int i=1; i<amount+1; i++){
            int min = Integer.MAX_VALUE;
            if(cns.contains(i)){
                dp[i] = 1;
                continue;
            }
            for(int j = i-1; j>0; j-- ){
                if(j < i-j) break;
                if(dp[j]==Integer.MAX_VALUE || dp[i-j]==Integer.MAX_VALUE) continue;
                min = Math.min(min, dp[j]+dp[i-j]);
            }
            dp[i] = min;
        }
        
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }
}