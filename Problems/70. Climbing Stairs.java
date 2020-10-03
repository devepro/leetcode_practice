/**
 * Method : Recursion with memorization (Used below)
 * Time complexity O(n)
 * Space complexity O(n)
 * 
 * Method : DP 
 * Time complexity O(n)
 * Space complexity O(n)
 * 
 * Method Fibbonaci using binet or formula
 * Time complexity O(logn)
 * Space complexity O(1)
 * 
 */
class Solution {
    int[] dp = null;
    public int climbStairs(int n) {
       dp = new int[n+1];
       
       return climb(n); 
    }
    
    public int climb(int stepsRemaining){
        if(stepsRemaining==0){
            return 1;
        }else if (stepsRemaining < 0){
            return 0;
        }
        if(dp[stepsRemaining]>0){
            return dp[stepsRemaining];
        }
        
        dp[stepsRemaining] = climb(stepsRemaining-1) + climb(stepsRemaining-2);
        
        return dp[stepsRemaining];
    }
}