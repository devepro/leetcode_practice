/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null ){ return false;}
        return sum(root, sum , 0 );
    }
    
    public boolean sum(TreeNode node, int sum , int sumUp){
        if(node==null){ return false;}
         
        if(node.left==null && node.right==null){
            if(sumUp + node.val == sum){
                return true;  
            }else{
                return false;
            } 
        } 
        return sum(node.left, sum , sumUp+node.val) || sum(node.right, sum, sumUp+node.val);
    }
}