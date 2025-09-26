class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        addParent(root, null);
        
        List<Integer> answer = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        
        dfs(target, k, visited, answer);
        return answer;
    }
    
    private void addParent(TreeNode cur, TreeNode parent) {
        if (cur != null) {
            cur.parent = parent;
            addParent(cur.left, cur);
            addParent(cur.right, cur);
        }
    }
    
    private void dfs(TreeNode cur, int distance, Set<TreeNode> visited, List<Integer> answer) {
        if (cur == null || visited.contains(cur)) return;
        visited.add(cur);
        if (distance == 0) {
            answer.add(cur.val);
            return;
        }
        dfs(cur.parent, distance - 1, visited, answer);
        dfs(cur.left, distance - 1, visited, answer);
        dfs(cur.right, distance - 1, visited, answer);
    }
}

class TreeNode {
    int val;
    TreeNode left, right, parent;
    TreeNode(int x) { val = x; }
}