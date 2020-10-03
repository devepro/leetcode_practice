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
 * Time complexity O(n) --> as each node is visited.
 * Space complexity O(h) --> h is the height of the binary tree
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        invertLeaves(root);
        return root;
    }
    
    public void invertLeaves(TreeNode root){
        if(root==null){
            return;
        }
        
        invertLeaves(root.left);
        invertLeaves(root.right);
        
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
        return;
    }
}