import java.util.*;

class FenwickTree {
    private int size;
    private int[] tree;

    public FenwickTree(int size) {
        this.size = size;
        this.tree = new int[size + 1];
    }

    public void update(int index, int delta) {
        while (index <= size) {
            tree[index] += delta;
            index += index & -index;
        }
    }

    public int query(int index) {
        int res = 0;
        while (index > 0) {
            res += tree[index];
            index -= index & -index;
        }
        return res;
    }
}

class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] posInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            posInNums2[nums2[i]] = i + 1;
        }

        FenwickTree ftLeft = new FenwickTree(n);
        int[] leftCounts = new int[n];
        for (int i = 0; i < n; i++) {
            int y = nums1[i];
            int posY = posInNums2[y];
            leftCounts[i] = ftLeft.query(posY - 1);
            ftLeft.update(posY, 1);  // Added delta = 1 here
        }

        FenwickTree ftRight = new FenwickTree(n);
        int[] rightCounts = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int y = nums1[i];
            int posY = posInNums2[y];
            rightCounts[i] = ftRight.query(n) - ftRight.query(posY);
            ftRight.update(posY, 1);  // Added delta = 1 here
        }

        long total = 0;
        for (int i = 0; i < n; i++) {
            total += (long) leftCounts[i] * rightCounts[i];
        }
        return total;
    }
}