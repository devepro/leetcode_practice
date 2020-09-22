class Solution {
    /**
     * TIme complexity O(n)
     * Space Complexity O(n)
     * 
     * Space complexity can be reduced to O(1) by using two pointers and then swapping at both ends.
     * 
     */
    public int[] sortArrayByParity(int[] A) {
        int even = 0;
        int odd = A.length-1;
        int[] B = new int[A.length];
        for(int num : A){
            if(num %2 ==0){
                B[even++] = num;
            }else{
                B[odd--] = num;
            }
        }
        return B;
    }
}