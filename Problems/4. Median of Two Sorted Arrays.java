class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i=0,j=0;
        List<Integer> allNums = new ArrayList<>();
        float ans = 0;
        while(i < nums1.length || j < nums2.length){
            if(i>=nums1.length){
                allNums.add(nums2[j]);
                j++;
            }else if(j>=nums2.length){
                allNums.add(nums1[i]);
                i++;
            }else{
                if(nums1[i]<nums2[j]){
                allNums.add(nums1[i]);
                i++;
                }else if(nums1[i]>nums2[j]){
                    allNums.add(nums2[j]);
                    j++;
                }else{
                    allNums.add(nums1[i]);
                    allNums.add(nums2[j]);
                    i++;
                    j++;
                }
            }
            
            
        }
        if(allNums.size()%2==0){
            int pos= allNums.size()/2;
            ans = (allNums.get(pos-1)+allNums.get(pos))/(float)2;         
        }else{
            int pos= allNums.size()/2;
            ans = allNums.get(pos);
        }
        return ans;
    }
}