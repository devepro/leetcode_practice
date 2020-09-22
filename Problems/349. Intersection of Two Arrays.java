/**
 * 
 * Time Complexity O(N+M)
 * Space Complexity O(N) or O(M)
 * 
 */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> a = new HashSet<>();
        Set<Integer> anset = new HashSet<>();
        
        if(nums1.length > nums2.length){
            for(int x: nums1){
                a.add(x);
            }
            
            for(int num : nums2){
                if(a.contains(num)){
                    anset.add(num);
                }
            }
        }else{
            for(int x: nums2){
                a.add(x);
            }
            
            for(int num : nums1){
                if(a.contains(num)){
                    anset.add(num);
                }
            }
        }
        
        int[] ans = new int[anset.size()];
        int i = 0;
        for(Integer b: anset){
            ans[i++] = b;
        }
        return ans;
    }
}