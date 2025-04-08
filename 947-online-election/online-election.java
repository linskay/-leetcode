import java.util.*;

class TopVotedCandidate {
    private int[] times;
    private List<Integer> leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new ArrayList<>();
        Map<Integer, Integer> counts = new HashMap<>();
        int leader = -1;

        for (int person : persons) {
            counts.put(person, counts.getOrDefault(person, 0) + 1);
            if (counts.get(person) >= counts.getOrDefault(leader, 0)) {
                leader = person;
            }
            leaders.add(leader);
        }
    }

    public int q(int t) {
        int left = 0, right = times.length - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (times[mid] <= t) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return leaders.get(left);
    }
}