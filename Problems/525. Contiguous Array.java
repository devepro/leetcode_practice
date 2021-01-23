/**
 * 
 * 
 * Time complexity : O(n). The entire array is traversed only once.
 * Space complexity : O(n). Maximum size of the HashMap mapmap will be \text{n}n, if all the elements are either 1 or 0.
 */
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> sum = new HashMap();
        
        sum.put(0,-1);
        int count = 0;
        int maxlen = 0;
        for (int i=0 ; i < nums.length ; i++){
            count = count + (nums[i]==0?-1:+1);
            if(sum.containsKey(count)){
                maxlen = Math.max(maxlen , i - sum.get(count));
            }else{
                sum.put(count, i);
            }
        }
        
        return maxlen;
    }
}