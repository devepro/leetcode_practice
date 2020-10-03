/**
 * 
 * Time complexity O(n)
 * Space complexity O(n)
 */
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] costs = new int[len];
        
        costs[len-1] = cost[len-1];
        costs[len-2] = cost[len-2];
        for(int i = len-3; i >=0 ; i--){
            costs[i] = cost[i]+Math.min(costs[i+1],costs[i+2]);
        }
        return Math.min(costs[0],costs[1]);
    }
}