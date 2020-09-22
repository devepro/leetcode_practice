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
 * time and space can be improved by changing creation of arrays to sending just the indexes of start and end of 
 * inorder and postorder arrays.
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder==null || postorder==null || inorder.length==0 || postorder.length==0) return null;
        TreeNode root = findRoot(inorder , postorder );
        return root;
    }
    
    public TreeNode findRoot(int[] inorder, int[] postorder){
        int length = postorder.length;
        if(length==0){return null;}
        int rootIndex = 0;
        TreeNode root = new TreeNode(postorder[length-1]);
        if(length==1){
            return root;
        }
        for(int a: inorder){
            if(a==postorder[length-1]){
               break; 
            }
            rootIndex++;
        }
        root.left = findRoot(Arrays.copyOfRange(inorder, 0, rootIndex),Arrays.copyOfRange(postorder, 0, rootIndex));
        root.right = findRoot(Arrays.copyOfRange(inorder, rootIndex+1, length),Arrays.copyOfRange(postorder, rootIndex, length-1));
        
        return root;
    }
}