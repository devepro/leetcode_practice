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
 * 
 * Time complexity : O(N) in the worst case when the tree is BST or the "bad" element is a rightmost leaf.
 * Space complexity : O(N) to keep stack.
 */
class Solution {
    boolean flag = true;
    Integer max=null;   
    public boolean isValidBST(TreeNode root) {
        if(root!=null){
            helper(root);
        }
        return flag;
    }
    
    public void helper(TreeNode root){
        if(!flag){
            return;
        }
        
        if(root.left!=null){
            helper(root.left);
        }
        if(max!=null){
            if(max < root.val){
                max = root.val;
            }else{
                flag = false;
            }
        }else{
            max = root.val;
        }
        
        if(root.right!=null){
            helper(root.right);
        }
    }
    
    
}