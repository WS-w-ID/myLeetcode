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
    private Map<Integer, Integer> indexMap = new HashMap<>(); 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n=inorder.length;
        for(int i=0; i<n; ++i){
            indexMap.put(inorder[i], i);
        }

        return build(preorder, inorder, 0, n-1, 0, n-1);
        
    }
    /**
     * [preorder_left, preorder_right] : 当前构造子树的先序遍历下标范围
     * [inorder_left, inorder_right] : 当前构造子树的中序遍历下标范围
     * */
    public TreeNode build(int[] preorder, int[] inorder, int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if(preorder_left > preorder_right)
            return null;

        int preorder_root = preorder_left;  // 子树根节点位置在先序的位置
        int inorder_root = indexMap.get(preorder[preorder_root]);   // 子树根节点在中序的位置

        TreeNode root = new TreeNode(preorder[preorder_root]);
        int size_left_subtree = inorder_root - inorder_left;    // 左子树的节点数量
        root.left = build(preorder, inorder, preorder_left+1, preorder_left+size_left_subtree, inorder_left, inorder_root-1);
        root.right = build(preorder, inorder, preorder_left+size_left_subtree+1, preorder_right, inorder_root+1, inorder_right);

        return root;
    }
}
