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
    public boolean isSymmetric(TreeNode root) {
        /**递归同时遍历两棵树 */
        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode p, TreeNode q){
        if(p==null && q==null)  // 终止
            return true;
        else if(p==null || q==null)
            return false;
        else if(p.val != q.val)
            return false;
        return isEqual(p.left, q.right) && isEqual(p.right, q.left);
    }
}
