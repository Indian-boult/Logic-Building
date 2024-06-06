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
    int min=Integer.MAX_VALUE; 
    int flag=0;
    public void move(TreeNode root,int value)
    {
        if(root==null)
        {
            return;
        }

        if(root.val<=min && root.val!=value)
        {
            min=root.val;
            flag=1;
        }
        move(root.left,value);
        move(root.right,value);
    }
    public int findSecondMinimumValue(TreeNode root) {
        move(root,min);
        int result=min;
        min=Integer.MAX_VALUE;
        flag=0;
        move(root,result);
        if(flag==0)
        {
            return -1;
        }
        return min;
    }
}