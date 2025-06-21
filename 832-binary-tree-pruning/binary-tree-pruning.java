class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    private boolean containsOne(TreeNode node) {
        if (node == null) return false;
        
        boolean leftContainsOne = containsOne(node.left);
        boolean rightContainsOne = containsOne(node.right);

        if (!leftContainsOne) node.left = null;
        if (!rightContainsOne) node.right = null;
        
        return node.val == 1 || leftContainsOne || rightContainsOne;
    }
}