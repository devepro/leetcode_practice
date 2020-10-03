/**
 * 
 * Time Complexity O(n+m)
 * Space Complexity O(1)
 * 
 */
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        
        int i = 0;
        int j = m-1;
        
        while(i < n && j > -1){
            int num = matrix[i][j];
            if(target == num){
                return true;
            }else if(target > num ){
                i++;
            }else if(target < num){
                j--;
            }
        }
        
        return false;
        
    }
}