/**
 * 
 * Solved using XOR operation
 * Time compelxity O(n)
 * Space Complecity O(1)
 * 
 * This can be solved using hashMaps also but would need extra space.
 */

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
          a ^= i;
        }
        return a;
    }
}