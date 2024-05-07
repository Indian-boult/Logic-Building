public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        //preOrder traversal, BFS
        //points to null when no left or right children
        if( root ==null)
            return "N";
        
        return ""+root.val+" "+serialize(root.left)+" "+serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //pass as scanner obj for easy accessing 
        return build(new Scanner(data));
    }
    
    public TreeNode build(Scanner sc){
        
        if(!sc.hasNext())
            return null;
        String s=sc.next();
        
        //no left or right children so points to null "N"
        if(s.equals("N"))
            return null;
        
        TreeNode root=new TreeNode(Integer.parseInt(s));
        root.left= build(sc);
        root.right=build(sc);
        
        return root;
    }
}