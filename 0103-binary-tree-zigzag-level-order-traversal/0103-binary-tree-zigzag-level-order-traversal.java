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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList();
        List<List<Integer>> answer = new ArrayList();
        Deque<TreeNode> deque = new LinkedList();
        boolean leftToRight = true;
        deque.addFirst(root);
        while (deque.size() != 0) {
            List<Integer> level = new ArrayList();
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = null;
                if (leftToRight) {
                    temp = deque.removeLast();
                } else {
                    temp = deque.removeFirst();
                }
                level.add(temp.val);

                if (leftToRight) { // if this level if left to right, this means next is right to left
                    if (temp.left != null) {
                        deque.addFirst(temp.left);
                    }
                    if (temp.right != null) {
                        deque.addFirst(temp.right);
                    }
                } else { // this means next is left to right
                    if (temp.right != null) {
                        deque.addLast(temp.right);
                    }
                    if (temp.left != null) {
                        deque.addLast(temp.left);
                    }
                }
            }

            leftToRight = !leftToRight; // next level is inverted order
            answer.add(level);
        }

        return answer;
    }
}