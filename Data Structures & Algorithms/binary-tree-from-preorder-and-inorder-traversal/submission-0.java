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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inOrderIndex = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inOrderIndex.put(inorder[i],i);
        return splitTree(preorder,inOrderIndex,0,0,preorder.length-1);
    }
    private TreeNode splitTree(int[] preorder,Map<Integer,Integer> inOrderIndex,int rootIndex,int left, int right){
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int mid = inOrderIndex.get(preorder[rootIndex]);
        if(mid> left){
            root.left = splitTree(preorder,inOrderIndex,rootIndex+1,left,mid-1);
        }   
        if(mid<right){
            root.right = splitTree(preorder,inOrderIndex,rootIndex+mid-left+1,mid+1,right);
        }
        return root;
    }
}
