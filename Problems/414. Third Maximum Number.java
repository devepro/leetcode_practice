class Solution {
    public int thirdMax(int[] nums) {
        Integer max=null, secondMax=null, thirdMax=null;
        for (int n : nums) {
            if (max!=null && max == n || secondMax !=null && secondMax ==n || thirdMax!=null && thirdMax ==n) {
                //avoid any reassignment.
                continue;
            }
            if (max == null || n > max) { 
                thirdMax = secondMax;
                secondMax = max;
                max = n;
            } else if (secondMax == null || n > secondMax) {
                thirdMax = secondMax;
                secondMax = n;
            } else if (thirdMax == null || n > thirdMax) {
                thirdMax = n;                
            }          
        }
        return thirdMax!=null ? thirdMax : max;
    }
}