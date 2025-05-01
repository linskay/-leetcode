import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        
        int left = 0;
        int right = Math.min(tasks.length, workers.length);
        int answer = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canComplete(tasks, workers, pills, strength, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    private boolean canComplete(int[] tasks, int[] workers, int pills, int strength, int k) {
        if (k == 0) return true;
        if (k > workers.length) return false;
        
        Deque<Integer> deque = new LinkedList<>();
        int ptr = workers.length - 1;
        int usedPills = 0;
        
        for (int i = k - 1; i >= 0; i--) {
            while (ptr >= workers.length - k && workers[ptr] + strength >= tasks[i]) {
                deque.addFirst(workers[ptr]);
                ptr--;
            }
            
            if (deque.isEmpty()) {
                return false;
            }
            
            if (deque.getLast() >= tasks[i]) {
                deque.removeLast();
            } else {
                if (usedPills >= pills) {
                    return false;
                }
                usedPills++;
                deque.removeFirst();
            }
        }
        
        return true;
    }
}