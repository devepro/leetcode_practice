class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0;
        for(int j = 0; j< nums.length; j++){
            int num = nums[j];
            nums[j] = 0;
            if(num!=0){
                nums[i++] = num;
            }
        }
    }
}