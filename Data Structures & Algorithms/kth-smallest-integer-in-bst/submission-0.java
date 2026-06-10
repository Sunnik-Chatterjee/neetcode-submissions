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
    int count;
    int result;
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        count--;
        if(count==0){ 
            result=root.val;
            return;
        }
        inOrder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        count=k;
        result=root.val;
        inOrder(root);
        return result;
    }
}
