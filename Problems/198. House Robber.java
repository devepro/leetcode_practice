/**
 * 
 * Time complexity O(n^2)
 */
class Solution {
    int[] dp = null;
    public int rob(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        dp = new int[nums.length];
        Arrays.fill(dp,-1);
        robNext(nums,0);
        return dp[0];
    }
    
    public int robNext(int[] nums , int start){
        if(start == nums.length-1){
            return nums[start];
        }else if(start == nums.length){
            return 0;
        }
        if(dp[start]!=-1){
            return dp[start];
        }
        int robbed = 0;
        for(int i = start+1 ; i <= nums.length; i++){
            if(i==start+1){
                robbed = Math.max(robbed, robNext(nums,i));
            }else{
                robbed = Math.max(robbed,nums[start] + robNext(nums, i));
            }
        }
        dp[start]= robbed;
        return robbed;
    }
}