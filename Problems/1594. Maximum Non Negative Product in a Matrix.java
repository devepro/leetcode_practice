class Solution {
    int mod = 1000000007;
    public int maxProductPath(int[][] grid) {
        return (int) (maxPath(grid,0,0,1L)%mod );
        
    }
    
    public long maxPath(int[][] grid, int i, int j, long product){
        if(i == grid.length-1 && j == grid[i].length-1){
                return (grid[i][j])*(product);
        }
        if(grid[i][j]==0) return 0;
        product = (grid[i][j])*(product);
        if(i < grid.length-1 && j < grid.length-1){
            return Math.max(maxPath(grid, i+1, j,product), maxPath(grid, i , j+1,product));
        }else if(j < grid.length-1){
            return maxPath(grid, i , j+1,product);
        }else if(i < grid.length-1){
            return maxPath(grid, i+1, j,product);
        }
        return 0;
    }
}

