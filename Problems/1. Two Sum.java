/**
 * 
 * Most Imp leetcode question
 * 
 * The Time Complexity is O(n)
 * Space Complexity is O(n)
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> info = new HashMap<>();
        
        for(int i=0 ; i< nums.length ; i++ ){
            if(info.containsKey(nums[i])){
                return new int[]{ info.get(nums[i]), i};
            }
            info.put(target-nums[i],i);
        }
        
        throw new IllegalArgumentException("No sums");
    }
}