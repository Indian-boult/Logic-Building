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
    int i;
    public TreeNode helper(int start,int end,int preorder[],int inorder[]) {
        int x = -1;
        for(int k=start; k<=end; k++) {
            if(inorder[k]==preorder[i]) {
                x = k;
            }
        }
        if(x==-1) {
            i--;
            return null;
        }
        //left
        TreeNode root = new TreeNode(preorder[i]);
        i++;
        root.left = helper(start,x-1,preorder,inorder);
        i++;
        root.right = helper(x+1,end,preorder,inorder);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        i = 0;
        return helper(0,inorder.length-1,preorder,inorder);
    }
}