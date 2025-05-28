class Solution {
    int solve(TreeNode root, int parent, int gParent) {
        if (root == null) {
            return 0;
        }
        return solve(root.left, root.val, parent) + solve(root.right, root.val, parent) + (gParent % 2 != 0 ? 0 : root.val);
    }

    public int sumEvenGrandparent(TreeNode root) {
        return solve(root, -1, -1);
    }
}