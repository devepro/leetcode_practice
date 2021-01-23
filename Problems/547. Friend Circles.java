class Solution {
    public int findCircleNum(int[][] M) {
        int groups = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i =0 ; i < M.length ; i++){
            if(!visited.contains(i)){
                groups++;
                dfs(i , M , visited);
            }
            
        }
        return groups;
    }
    
    public void dfs(int source, int[][] M, Set<Integer> visited){
        visited.add(source);
        for(int j = 0 ; j < M.length ; j++){
            if(M[source][j]==1 && !visited.contains(j) && source!=j){
                dfs(j , M , visited);
            }
        }
    }
}