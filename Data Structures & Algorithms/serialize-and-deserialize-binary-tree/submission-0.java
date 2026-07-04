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

public class Codec {
    void preOrder(TreeNode root, StringBuilder sb){
        if(root==null){
            sb.append("N").append(",");
            return;
        }
        sb.append(root.val).append(",");
        preOrder(root.left,sb);
        preOrder(root.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.isEmpty()) return null;
        String[] tokens = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(tokens));
        return buildPreTree(q);
    }
    TreeNode buildPreTree(Queue<String> q){
        String val = q.poll();
        if(val.equals("N")) return null;
        TreeNode node = new TreeNode(Integer.parseInt(val));
        node.left = buildPreTree(q);
        node.right = buildPreTree(q);
        return node;
    }
}
