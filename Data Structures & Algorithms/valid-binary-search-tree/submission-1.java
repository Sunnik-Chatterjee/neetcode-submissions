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
    void inOrder(List<Integer> list, TreeNode root){
        if(root==null) return;
        inOrder(list,root.left);
        list.add(root.val);
        inOrder(list,root.right);
    }
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(list,root);
        int prev=list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)<=prev) return false;
            prev=list.get(i);
        }
        return true;
    }
}
