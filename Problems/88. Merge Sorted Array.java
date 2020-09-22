class Solution {
    /**
     * 
     * Start from the end and then go on adding elements
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums2Last = n-1;
        int nums1Last = m-1;
        int numIndex = nums1.length;
        for(int i = nums1.length-1; i>=0 ; i--){
            if(nums2Last < 0){
                break;
            }
            if(nums1Last < 0){
                nums1[i] = nums2[nums2Last--]; 
                continue;
            }
            if(nums1[nums1Last] > nums2[nums2Last]){
                nums1[i] = nums1[nums1Last--]; 
            }else{
                nums1[i] = nums2[nums2Last--]; 
            }
        }
        
    } 
}