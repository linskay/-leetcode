class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupId = m;
        for (int i = 0; i < n; i++) if (group[i] == -1) group[i] = groupId++;

        Map<Integer, List<Integer>> itemGraph = new HashMap<>();
        Map<Integer, List<Integer>> groupGraph = new HashMap<>();
        int[] itemIndegree = new int[n], groupIndegree = new int[groupId];
        for (int i = 0; i < n; i++) itemGraph.put(i, new ArrayList<>());
        for (int i = 0; i < groupId; i++) groupGraph.put(i, new ArrayList<>());

        for (int curr = 0; curr < n; curr++) {
            for (int prev : beforeItems.get(curr)) {
                itemGraph.get(prev).add(curr);
                itemIndegree[curr]++;
                if (group[curr] != group[prev]) {
                    groupGraph.get(group[prev]).add(group[curr]);
                    groupIndegree[group[curr]]++;
                }
            }
        }

        List<Integer> itemOrder = topologicalSort(itemGraph, itemIndegree);
        List<Integer> groupOrder = topologicalSort(groupGraph, groupIndegree);
        if (itemOrder.isEmpty() || groupOrder.isEmpty()) return new int[0];

        Map<Integer, List<Integer>> orderedGroups = new HashMap<>();
        for (int item : itemOrder) orderedGroups.computeIfAbsent(group[item], k -> new ArrayList<>()).add(item);

        List<Integer> answerList = new ArrayList<>();
        for (int groupIndex : groupOrder) answerList.addAll(orderedGroups.getOrDefault(groupIndex, new ArrayList<>()));

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> topologicalSort(Map<Integer, List<Integer>> graph, int[] indegree) {
        List<Integer> visited = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int key : graph.keySet()) if (indegree[key] == 0) stack.add(key);

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            visited.add(curr);
            for (int next : graph.get(curr)) if (--indegree[next] == 0) stack.add(next);
        }

        return visited.size() == graph.size() ? visited : new ArrayList<>();
    }
}