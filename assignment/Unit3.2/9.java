class Solution {
    public int h(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(h(root.left), h(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(h(root.left) - h(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
