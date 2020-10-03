/**
 * Time complexity O(1) as steps is constant 81 or O(n^2)
 * Space complexity O(1) .. or O(n^2)
 */
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet();
        for (int i =0;i<9;i++){
            for (int j =0;j<9;j++){
                if (board[i][j] != '.') {
                    String curr = "("+board[i][j]+")";
                    if(!seen.add(i+curr) || !seen.add(curr+j) || !seen.add(i/3+curr+j/3))                     {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}