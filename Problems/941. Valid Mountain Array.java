class Solution {
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3) return false;
        
        if (! (A[1] > A[0])) return false;
        int s = 0;
        boolean ans = true;
        for(int i = 1; i < A.length ; i++){
            if(A[i] > A[i-1] && s==0){
                continue;
            }else if(A[i] < A[i-1] && s==0){
                s = 1;
                continue;
            }else if(A[i] < A[i-1] && s==1){
                continue;
               
            }else{
                ans = false;
                break;
            }
            
        }
        
        return s==0?false:ans;
    }
}