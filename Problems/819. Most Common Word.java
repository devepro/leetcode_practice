/**
 * 
 * Time complexity O(N+M)
 * Space complexity O(N+M)
 * 
 */
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet();
        HashMap<String, Integer> map = new HashMap();
        int max = 0;
        String ans = null;
        for(String a : banned){
            ban.add(a);
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i= 0 ; i < paragraph.length() ; i++){
            char cur = Character.toLowerCase(paragraph.charAt(i));
            if(Character.isLetter(cur)){
                sb.append(cur);
            }
            if(' '== paragraph.charAt(i) || !Character.isLetter(cur) || i == paragraph.length()-1){
                String word = sb.toString();
                if(!ban.contains(word) && word.length()>0){
                    map.put(word , map.getOrDefault(word, 0) +1);
                    if(map.get(word) > max){
                        max = map.get(word);
                        ans = word;
                    }  
                }
                sb.setLength(0);
            }
        }
        
        return ans;
    }
}