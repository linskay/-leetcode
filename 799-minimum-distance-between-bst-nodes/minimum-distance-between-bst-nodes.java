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
    List<Integer> inorderNodes = new ArrayList<>();
    
    private void inorderTraversal(TreeNode root) {
        if (root == null) return;
        
        inorderTraversal(root.left);
        inorderNodes.add(root.val);
        inorderTraversal(root.right);
    }
    
    public int minDiffInBST(TreeNode root) {
        inorderTraversal(root);
        
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < inorderNodes.size(); i++) {
            minDistance = Math.min(minDistance, inorderNodes.get(i) - inorderNodes.get(i - 1));
        }
        
        return minDistance;
    }
}