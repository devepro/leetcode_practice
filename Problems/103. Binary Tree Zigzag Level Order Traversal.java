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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) return new ArrayList();
        Stack<TreeNode> currStack = new Stack<>();
        Stack<TreeNode> nextStack = new Stack<>();
        int level = 0;
        currStack.push(root);
        List<List<Integer>> ans = new ArrayList();
        List<Integer> levelZero = new ArrayList<>();
        levelZero.add(root.val);
        ans.add(levelZero);
        do{
            List<Integer> levelList = new ArrayList<>();
            while(!currStack.isEmpty()){
              
                TreeNode curr = currStack.pop();
                if(level%2==0){
                    if(curr.right!=null){
                        levelList.add(curr.right.val);
                        nextStack.add(curr.right);
                    }
                    if(curr.left!=null){
                        levelList.add(curr.left.val);
                        nextStack.add(curr.left);
                    }
                }else{
                    if(curr.left!=null){
                        levelList.add(curr.left.val);
                        nextStack.add(curr.left);
                    }
                    if(curr.right!=null){
                        levelList.add(curr.right.val);
                        nextStack.add(curr.right);
                    }
                }    
            }
            level++;
            Stack<TreeNode> temp = currStack;
            currStack = nextStack;
            nextStack = temp;
            if(!levelList.isEmpty()) ans.add(levelList);
        }while(!currStack.isEmpty());
    
        return ans;
    }
}