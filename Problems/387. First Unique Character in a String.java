/**
 * 
 * Time complexity : \mathcal{O}(N)O(N) since we go through the string of length N two times.
 * Space complexity : \mathcal{O}(1)O(1) because English alphabet contains 26 letters.
 */

class Solution {
    public int firstUniqChar(String s) {
        Map<Character,Integer> ans = new HashMap<>();
        
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            ans.put(c, ans.getOrDefault(c,0)+1);
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (ans.get(s.charAt(i)) == 1) 
                return i;
        }
        
        return -1;
    }
}