class Solution {
    public int kthGrammar(int N, int K) {
        return solve(N,K,true);
    }
    
    public int solve(int N, int K, boolean left){
        if(N==1 && K==1){
           if(left){
               return 0;
           }else{
               return 1;
           } 
        }
        
        int mid =(int) Math.pow(2,N-2);
        if(K<=mid){
            return solve(N-1,K, left);
        }else{
            return solve(N-1,K-mid,!left );
        }
    }
}