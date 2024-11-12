/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return false;
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        // 当前子树有节点p 和 节点q
        if((lson && rson) || ((root.val==p.val || root.val==q.val) && (lson || rson))){
            ans = root;
        }
        // 当前子树中有节点p 或 节点q
        return lson || rson || root.val == p.val || root.val == q.val;
    }
}
