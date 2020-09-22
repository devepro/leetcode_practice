class Solution {
    /**
     * Time complexity O(nlogn)
     * Space complexity O(n)
     * 
     */
    public int heightChecker(int[] heights) {
        int[] comp = heights.clone();
        Arrays.sort(heights);
        int ans = 0;
        for(int i= 0; i< heights.length ; i++){
            if(comp[i]!=heights[i]){
                ans++;
            }
        }
        
        return ans;
    }
}