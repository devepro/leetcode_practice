class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length ; i++){
            dp[i] = dp[i-1]+nums[i];
            int sum = dp[i];
            max = Math.max(max, sum);
            int j = 0;
            while(j<i){
                max = Math.max(max,sum - dp[j]);
                j++;
            }
        }
        return max;                                                                                       
    }
}