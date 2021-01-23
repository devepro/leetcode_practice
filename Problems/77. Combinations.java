/**
 * 
 * 
 */
class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> combine(int n, int k) {
        combinations(n,1,k, new ArrayList());
        return ans;
    }
    
    public void combinations(int n, int start, int rem, List<Integer> list){
        if(rem==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = start ; i <= n ; i++){
            list.add(i);
            combinations(n,i+1, rem-1, list);
            list.remove(Integer.valueOf(i));
        }
        
        return;
    }
}