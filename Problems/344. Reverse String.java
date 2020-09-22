/**
 * Time Complexity O(n/2) --> O(n)
 * Space Complexity O(1)
 * 
 */
class Solution {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}