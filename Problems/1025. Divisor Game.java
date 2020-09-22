class Solution {
    public boolean divisorGame(int N) {
        /**
        2 = win
        3 = lose
        4 = win
        5 = lose
        6 = (3) win
        7 = lose
        8 = win
        [0,1,2,1,]
        */
        int[] dp = new int[N+1];
        dp[1] = 1;//lose
        for (int i = 2;i<=N ; i++){
            for( int j = 1; j < i ; j++){
                if(i%j == 0){
                    if(dp[i-j]==1){
                        dp[i] = 2;
                        break;
                    }else{
                        dp[i] = 1;
                    }
                }
            }
        }
        return dp[N]==2?true:false;
    }
}