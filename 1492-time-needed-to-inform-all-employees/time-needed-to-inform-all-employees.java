class Solution {
    private int maxTime = Integer.MIN_VALUE;
    
    private void DFS(List<Integer>[] adjList, int[] informTime, int curr, int time) {
        maxTime = Math.max(maxTime, time);
        for (int adjacent : adjList[curr]) {
            DFS(adjList, informTime, adjacent, time + informTime[curr]);
        }
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] adjList = new List[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] != -1) {
                adjList[manager[i]].add(i);
            }
        }
        DFS(adjList, informTime, headID, 0);
        return maxTime;
    }
}
