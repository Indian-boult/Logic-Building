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
    
    private int count = 0; // This will hold the count of valid nodes.

    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return count;
    }

    private int[] postOrder(TreeNode node) {
        if (node == null) return new int[] {0, 0}; // Returns {sum, count}

        int[] left = postOrder(node.left);
        int[] right = postOrder(node.right);

        int sum = left[0] + right[0] + node.val;
        int nodesCount = left[1] + right[1] + 1;
        
        // Calculate average and compare it to the node's value
        if (node.val == sum / nodesCount) {
            count++;
        }

        return new int[] {sum, nodesCount};
    }
}