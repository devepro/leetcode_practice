/**
 * 
 * Time complexity O(nm)
 * Space complexity O(nm)
 * 
 * Dp style algorithm
 */
class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        if(matrix.length==0 || matrix[0].length==0) return ans;
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int i= 0; i < matrix.length ; i++){
            if(matrix[i][0]=='1'){
                dp[i][0] = 1;
                ans =1;
            }else{
                dp[i][0] = 0; 
            }
        }
        for(int i= 0; i < matrix[0].length ; i++){
            if(matrix[0][i]=='1'){
                dp[0][i] = 1;
                ans =1;
            }else{
                dp[0][i] = 0; 
            }
        }
        
        for(int i= 1; i < matrix.length ; i++){
            for(int j= 1; j < matrix[0].length ; j++){
                if(matrix[i][j]=='0'){
                   dp[i][j]=0;
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    ans = Math.max(ans, dp[i][j]); 
                }
            }
        }
        
        return ans*ans;
    }
}