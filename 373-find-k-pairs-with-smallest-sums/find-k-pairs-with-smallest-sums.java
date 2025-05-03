import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        PriorityQueue<Triple> minHeap = new PriorityQueue<>(Comparator.comparingInt(t -> t.sum));
        minHeap.add(new Triple(nums1[0] + nums2[0], 0, 0));
        visited.add(new Pair<>(0, 0));

        while (k-- > 0 && !minHeap.isEmpty()) {
            Triple top = minHeap.poll();
            int i = top.i, j = top.j;
            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (i + 1 < m && !visited.contains(new Pair<>(i + 1, j))) {
                minHeap.add(new Triple(nums1[i + 1] + nums2[j], i + 1, j));
                visited.add(new Pair<>(i + 1, j));
            }

            if (j + 1 < n && !visited.contains(new Pair<>(i, j + 1))) {
                minHeap.add(new Triple(nums1[i] + nums2[j + 1], i, j + 1));
                visited.add(new Pair<>(i, j + 1));
            }
        }

        return ans;
    }

    class Triple {
        int sum, i, j;
        Triple(int sum, int i, int j) {
            this.sum = sum;
            this.i = i;
            this.j = j;
        }
    }
}
