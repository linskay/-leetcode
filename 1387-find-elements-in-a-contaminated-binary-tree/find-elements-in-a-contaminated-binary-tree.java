import java.util.HashSet;
import java.util.Set;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class FindElements {
    private TreeNode root;
    private Set<Integer> values = new HashSet<>();
    
    public FindElements(TreeNode root) {
        this.root = root;
        root.val = 0;
        values.add(0);
        recover(root);
    }
    
    private void recover(TreeNode node) {
        if (node.left != null) {
            node.left.val = 2 * node.val + 1;
            values.add(node.left.val);
            recover(node.left);
        }
        if (node.right != null) {
            node.right.val = 2 * node.val + 2;
            values.add(node.right.val);
            recover(node.right);
        }
    }
    
    public boolean find(int target) {
        return values.contains(target);
    }
}