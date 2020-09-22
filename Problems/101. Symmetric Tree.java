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
 * Time Complexity O(n) --> as we go through each node once
 * Space Complexity O(n) --> worst case as we do recursion and tree could be linear
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isMirror(root.left,root.right);
    }
    
    public boolean isMirror(TreeNode tree1, TreeNode tree2){
        if(tree1 ==null && tree2 ==null){
            return true;
        }
        
        if(tree1!=null && tree2!=null && tree1.val==tree2.val){
            return isMirror(tree1.left,tree2.right) && isMirror(tree1.right,tree2.left);
        }
        return false;
    }
}