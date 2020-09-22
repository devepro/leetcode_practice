/**
 * 
 * Time Complexity O(n^2)
 * Space Complexity O(1)
 */

class Solution {
    public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) return 0;
    int count = 0;
    for(int i = 0; i< grid.length ; i++){
        for(int j =0; j<grid[i].length ; j++){
            if(grid[i][j]=='1'){
                island(grid,i,j);
                count++;
            }
        }
    }
    return count;    
    }
    
    public void island(char[][] grid,int i,int j){
        if(i<0 || i >= grid.length || j < 0 || j >= grid[i].length){
            return ;
        }
        if(grid[i][j]=='1'){
            grid[i][j] = '2';
            island(grid, i,j+1);
            island(grid, i,j-1);
            island(grid, i-1,j);
            island(grid, i+1,j);
        }
    }
}