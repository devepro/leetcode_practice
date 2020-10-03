/**
 * 
 * Time complexity : O(nlogn). Binary search takes \log nlogn time and it is called nn times.
 * Space complexity : O(n)O(n). dpdp array of size nn is used.
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for(int num : nums){
            int i = Arrays.binarySearch(dp, 0, len , num);
            if(i < 0){
                i = -(i + 1);
            }
            dp[i] = num;
            if(i == len){
                len++;
            }
        }
        return len;
    }
}