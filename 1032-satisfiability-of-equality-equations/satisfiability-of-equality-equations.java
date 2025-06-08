public class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                uf.unionSet(x, y);
            }
        }
        
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int x = eq.charAt(0) - 'a';
                int y = eq.charAt(3) - 'a';
                if (uf.connected(x, y)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private class UnionFind {
        private int[] parent;
        
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public void unionSet(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
        
        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }
}