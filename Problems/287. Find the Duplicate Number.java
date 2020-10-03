/**
 * 
 * Time complexity O(n)
 * Space complexity O(1)
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int tort = 0;
        int hare = 0;
        
        do{
            tort = nums[tort];
            hare = nums[nums[hare]];
        }while(tort!=hare);
        
        tort = 0;
        while(tort!=hare){
            tort = nums[tort];
            hare = nums[hare];
        }
        return hare;
    }
}