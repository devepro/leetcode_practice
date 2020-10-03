/**
 * 
 * TIme complexity O(n^2)
 * Space complexity O(n^2)
 */
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> sums = new HashMap();
        
        int count = 0;
        for(int i= 0 ; i <A.length ;i++ ){
            for(int j= 0 ; j <B.length ;j++ ){
                sums.put(A[i]+B[j], sums.getOrDefault(A[i]+B[j],0)+1);
            }       
        }
        for(int i= 0 ; i < C.length;i++ ){
            for(int j= 0 ; j < D.length ;j++ ){
                count = count + sums.getOrDefault(-(C[i]+D[j]),0);
            }       
        }
        
        return count;
    }
}