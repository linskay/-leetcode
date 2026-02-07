public class Solution {
    private int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode constructBST(int[] preorder, int lower, int upper) {
        if (index == preorder.length) {
            return null;
        }

        int val = preorder[index];
        if (val < lower || val > upper) {
            return null;
        }

        index++;
        TreeNode root = new TreeNode(val);
        root.left = constructBST(preorder, lower, val);
        root.right = constructBST(preorder, val, upper);
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}