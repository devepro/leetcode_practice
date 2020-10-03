/**
 * 
 * Time complexity O(N*K) k is number of words;
 * Space complexity O(n)
 * 
 */

class Solution {
    Boolean[] dp = null;
    List<String> words = new ArrayList<>();
    Set<String> wordDic = new HashSet<>();
    String str = "";
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict){
            wordDic.add(word);
        }
        dp = new Boolean[s.length()+1];
        str = s;
        return solveWordBreak(0);
    }
    
    public boolean solveWordBreak(int start){
        if(start == str.length()){
            return true;
        }
        if(dp[start] != null) return dp[start];
        dp[start] = false;
        StringBuilder s = new StringBuilder();
        for(int i = start ; i< str.length() ; i++){
            s.append(str.charAt(i));
            if(wordDic.contains(s.toString())){
                words.add(s.toString());
                if(solveWordBreak(i+1)){
                    dp[i+1] =true;
                    return true;
                }
                words.remove(s.toString());
            }
        }
        return false;
    }
}