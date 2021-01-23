/**
 * 
 * Notes:
 * Utilized difference of ins and outs from a node to find
 * 
 * Graph 
 * Time complexity O(n)
 * Space complexity O(n)
 */
class Solution {
    public int findJudge(int N, int[][] trust) {
        
        int[] trustGraph = new int[N+1];
        for(int i = 0; i < trust.length;i++){
            trustGraph[trust[i][0]]--;
            trustGraph[trust[i][1]]++;
        }
        
        for(int i = 1; i <= N;i++){
           if(trustGraph[i]==N-1) return i;
        }
        
        return -1;
    }
}