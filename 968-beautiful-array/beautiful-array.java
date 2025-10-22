import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] beautifulArray(int n) {
        List<Integer> result = construct(n);
        int[] resArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resArray[i] = result.get(i);
        }
        return resArray;
    }
    
    private List<Integer> construct(int n) {
        if (n == 1) {
            List<Integer> base = new ArrayList<>();
            base.add(1);
            return base;
        }
        List<Integer> odd = construct((n + 1) / 2);
        List<Integer> even = construct(n / 2);
        List<Integer> result = new ArrayList<>();
        for (int x : odd) {
            result.add(2 * x - 1);
        }
        for (int x : even) {
            result.add(2 * x);
        }
        return result;
    }
}