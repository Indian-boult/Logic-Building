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
    ArrayList<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return list;
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        solve(root);
        return list;
    }

    public void solve(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        solve(root.left);
        solve(root.right);
    }
}