class Solution {
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> subsets(int[] nums) {
        solve(nums, 0 , new ArrayList<Integer>());
        ans.add(new ArrayList());
        System.out.println(c);
        return ans;
    }
    
    public void solve(int[] nums , int start, List<Integer> list ){
        if(start >= nums.length){
            return;
        }
        for(int i = start; i< nums.length; i++){
            list.add(nums[i]);
            ans.add(new ArrayList(list));
            solve(nums , i+1 , list);
            list.remove(new Integer(nums[i]));
        }
            
    }
}