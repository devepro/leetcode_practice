/**
 * 
 * Time Complexity O(n)
 * Space Complexity O(1)
 * 
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int ls = s.length();
        int lp = p.length();
        if(ls < lp ) return new ArrayList();
        
        List<Integer> ans = new ArrayList();
        
        HashMap<Character, Integer> pmap = new HashMap();
        HashMap<Character, Integer> smap = new HashMap();
        
        for(char a: p.toCharArray()){
            pmap.put(a , pmap.getOrDefault(a,0)+1 );
        }
        
        
        for(int i= 0 ; i < ls ; i++){
            char b = s.charAt(i);
            smap.put(b, smap.getOrDefault(b, 0)+1 );   
            
            if(i-lp >= 0){
                char c = s.charAt(i-lp);
                if(smap.get(c)>1){
                    smap.put(c , smap.get(c)-1);
                }else{
                    smap.remove(c);
                }
                
                
            }            
            if(smap.equals(pmap)){
                ans.add(i-lp+1);
            }
        }
        
        return ans;
    }
}