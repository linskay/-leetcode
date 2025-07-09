public class Solution {
    private String ans = "~";

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return ans;
    }

    private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) return;
        path.append((char) (node.val + 'a'));
        if (node.left == null && node.right == null) {
            path.reverse();
            String s = path.toString();
            path.reverse();
            if (s.compareTo(ans) < 0) {
                ans = s;
            }
        }
        dfs(node.left, path);
        dfs(node.right, path);
        path.deleteCharAt(path.length() - 1);
    }
}