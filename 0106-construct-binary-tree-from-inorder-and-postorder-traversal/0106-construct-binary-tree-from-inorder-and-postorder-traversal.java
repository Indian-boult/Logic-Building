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
   public TreeNode buildTree( int[] inorder, int[] postorder) {
        HashMap<Integer,Integer>indexmap= new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            indexmap.put(inorder[i],i);
        }
        int n=inorder.length-1;
        int m=postorder.length-1;


        
        TreeNode root=ConstructTree(postorder,inorder,indexmap,0,n,0,m);
            return root;
        }

        public TreeNode ConstructTree(int[] postorder, int[] inorder,HashMap<Integer,Integer>indexmap,int postIndStart,int postIndEnd,int inIndStart,int inIndEnd){
            // base case
            if (postIndStart>postIndEnd||inIndStart>inIndEnd){
                return null;
            }
            int rootdata= postorder[postIndEnd];
            int rootindex=indexmap.get(rootdata);
            TreeNode root=new TreeNode(rootdata);
            int leftTreesize= rootindex-inIndStart;
            int rightTreesize= inIndEnd-rootindex;

            root.left=ConstructTree(postorder,inorder,indexmap,postIndStart,postIndStart+leftTreesize-1,inIndStart,rootindex-1);
            root.right=ConstructTree(postorder,inorder,indexmap,postIndStart+leftTreesize,postIndStart+leftTreesize+rightTreesize-1,rootindex+1,inIndEnd);
            return root;
        }
}