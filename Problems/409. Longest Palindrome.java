/**
 * 
 * Time complexity O(n^2)
 * Space complexity O(1) 128 max
 * 
 */
class Solution {
    public int longestPalindrome(String s) {
        int l = s.length();
        boolean cntr = false;
        int count = 0;
        HashMap<Character, Integer> map = new HashMap();
        for(int i = 0; i< l ; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }
        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            if(entry.getValue()%2==1){
                cntr = true;
            }
            count = count + entry.getValue()/2;
        }
        return cntr? count*2+1: count*2;
    }
}