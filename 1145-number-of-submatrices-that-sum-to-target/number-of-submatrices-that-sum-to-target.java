class Solution {
  public int numSubmatrixSumTarget(int[][] matrix, int target) {
    int r = matrix.length, c = matrix[0].length;

    int[][] ps = new int[r + 1][c + 1];
    for (int i = 1; i < r + 1; ++i) {
      for (int j = 1; j < c + 1; ++j) {
        ps[i][j] = ps[i - 1][j] + ps[i][j - 1] - ps[i - 1][j - 1] + matrix[i - 1][j - 1];
      }
    }

    int count = 0, currSum;
    Map<Integer, Integer> h = new HashMap();
    for (int r1 = 1; r1 < r + 1; ++r1) {
      for (int r2 = r1; r2 < r + 1; ++r2) {
        h.clear();
        h.put(0, 1);
        for (int col = 1; col < c + 1; ++col) {
          currSum = ps[r2][col] - ps[r1 - 1][col];
          count += h.getOrDefault(currSum - target, 0);
          h.put(currSum, h.getOrDefault(currSum, 0) + 1);
        }
      }
    }

    return count;
  }
}