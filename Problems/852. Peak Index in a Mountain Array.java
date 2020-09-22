/**
 * 
 * Time Complexity O(n)
 * Space Complexity O(1)
 * 
 * This is also possible in O(NlogN) using binary search
 */
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        
        int i = 0;
        while(arr[i]<arr[i+1]){
            i++;
        }
        return i;
    }
}