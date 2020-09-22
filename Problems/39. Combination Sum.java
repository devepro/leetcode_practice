/**
 * 
 * Time Complexity O(N^M)
 * Space Complexity O(K) --> max height of K
 * 
 */

class Solution {
    List<List<Integer>> ans = new ArrayList();
    int[] cand;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        cand = candidates;
        solve( new ArrayList(), target , 0);
        return ans;
    }
    
    
    public void solve( List<Integer> list ,int target, int start){
        if(target == 0){
            ans.add(new ArrayList(list));
            return;
        }
        if(target<0){
            return;
        }
        
        for(int i = start; i< cand.length ; i++){
            if(target >=cand[i]){
                list.add(cand[i]);
                solve( list, target-cand[i], i );
                list.remove(new Integer(cand[i]));
            }
        }
    }
}