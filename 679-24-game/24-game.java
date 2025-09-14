import java.util.*;

class Solution {
    public List<Double> generatePossibleResults(double a, double b) {
        List<Double> res = new ArrayList<>(Arrays.asList(a + b, a - b, b - a, a * b));
        if (a != 0) res.add(b / a);
        if (b != 0) res.add(a / b);
        return res;
    }

    public boolean checkIfResultReached(List<Double> list) {
        if (list.size() == 1) return Math.abs(list.get(0) - 24) <= 0.1;

        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                List<Double> newList = new ArrayList<>();
                for (int k = 0; k < list.size(); k++) {
                    if (k != i && k != j) newList.add(list.get(k));
                }
                for (double res : generatePossibleResults(list.get(i), list.get(j))) {
                    newList.add(res);
                    if (checkIfResultReached(newList)) return true;
                    newList.remove(newList.size() - 1);
                }
            }
        }
        return false;
    }

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return checkIfResultReached(list);
    }
}
