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
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int ldepth = 0, rdepth = 0;
        TreeNode p = root;
        while(p.left!=null){
            ++ldepth;
            p = p.left;
        }
        p = root;
        while(p.right != null){
            ++rdepth;
            p = p.right;
        }
        if(ldepth == rdepth)
            return (int)Math.pow(2, ldepth+1)-1;
        return countNodes(root.left) + countNodes(root.right) + 1;    
    }
}
