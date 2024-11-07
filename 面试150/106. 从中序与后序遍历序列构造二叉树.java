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
    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        for(int i=0; i<n; ++i){
            indexMap.put(inorder[i], i);
        }
        return build(inorder, postorder, 0, n-1, 0, n-1);
    }

    /**
     * [inleft, inright] : 当前构造子树的中序遍历下标范围
     * [postleft, postright] : 当前构造子树的后序遍历下标范围
     * */
    public TreeNode build(int[] inorder, int[] postorder, int inleft, int inright, int postleft, int postright){
        if(inleft > inright)
            return null;

        int rootVal = postorder[postright];
        TreeNode root = new TreeNode(rootVal);
        int indexRoot = indexMap.get(rootVal);
        int left_subtree_size = indexRoot - inleft; // 左子树节点数量

        // root.left = build(preorder, inorder, preorder_left+1, preorder_left+size_left_subtree, inorder_left, inorder_root-1);
        // root.right = build(preorder, inorder, preorder_left+size_left_subtree+1, preorder_right, inorder_root+1, inorder_right);
        root.left = build(inorder, postorder, inleft, indexRoot-1, postleft, postleft+left_subtree_size-1);
        root.right = build(inorder, postorder, indexRoot+1, inright, postleft+left_subtree_size, postright-1);

        return root;
    }
}
