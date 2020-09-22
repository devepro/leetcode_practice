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
 * Time Complexity: O(N). We visit every node once.
 * Space Complexity: O(N), the size of our implicit call stack during our depth-first search.
 * 
 */
class Solution {
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        depth(root);   
        return ans;
    }
    
    public int depth(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        ans = Math.max(ans, leftDepth+rightDepth);
        return Math.max(leftDepth, rightDepth)+1;
    }
}