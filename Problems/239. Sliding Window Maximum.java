/**
 * 
 * Time Complexity O(n)
 * Space Complexity O(k)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length-k+1;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] ans = new int[len];
        for(int i = 0; i < nums.length ; i++){
            
            while(queue.peekLast() != null && nums[queue.peekLast()] < nums[i] ){
                queue.removeLast();
            }
            
            while(i >= k && queue.peekFirst()!=null && queue.peekFirst() <= i-k){
                queue.removeFirst();
            }
            
            queue.addLast(i);
            if(i >= k-1){
                ans[i-(k-1)] = nums[queue.peekFirst()]; 
            }
            
        }
        
        return ans;
    }
}