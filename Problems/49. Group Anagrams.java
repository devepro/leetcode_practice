/**
 * 
 * Time Complexity: O(NK), where NN is the length of strs, and KK is the maximum length of a string in strs. Counting each string is linear in the size of the string, and we count every string.
 * Space Complexity: O(NK), the total information content stored in ans.
 * 
 * Other way is to sort the array and create the key
 * Time complexity (N KlogK)
 * 
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap();
        int[] count = new int[26];
        for(String str: strs){
            Arrays.fill(count, 0);
            for(char c: str.toCharArray()) count[c - 'a']++;
            
            StringBuilder sb = new StringBuilder("");
            for(int i = 0; i < 26 ; i++){
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if(!ans.containsKey(key)) ans.put(key,new ArrayList());
            ans.get(key).add(str);
        }
        
        return new ArrayList(ans.values());
        
    }
}