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
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int maxDep = 0;
        int d1=maxDepth(root.left)+1;
        int d2=maxDepth(root.right)+1;
        maxDep = Math.max(maxDep,Math.max(d1,d2));
        return maxDep;
    }
}
