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
class BSTIterator {
    int index;
    List<Integer> arr;

    public BSTIterator(TreeNode root) {
        index = -1;
        arr = new ArrayList<>();
        inorder(root);
    }
    
    public int next() {
        return arr.get(++index);
    }
    
    public boolean hasNext() {
        return index < arr.size()-1;
    }

    public void inorder(TreeNode root){
        if(root.left != null)
            inorder(root.left);
        arr.add(root.val);
        if(root.right != null)
            inorder(root.right);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
