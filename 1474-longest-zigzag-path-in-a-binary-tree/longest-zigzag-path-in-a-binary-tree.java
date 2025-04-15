class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    private int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxLength;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) {
            return;
        }
        maxLength = Math.max(maxLength, length);
        if (isLeft) {
            dfs(node.left, false, length + 1);
            dfs(node.right, true, 1);
        } else {
            dfs(node.right, true, length + 1);
            dfs(node.left, false, 1);
        }
    }
}
