import java.util.*;

public class RandomizedSet {
    private Map<Integer, Integer> dict;
    private List<Integer> list;
    private Random rand;

    public RandomizedSet() {
        dict = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (dict.containsKey(val)) {
            return false;
        }
        dict.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!dict.containsKey(val)) {
            return false;
        }
        int index = dict.get(val);
        int lastElement = list.get(list.size() - 1);
        list.set(index, lastElement);
        dict.put(lastElement, index);
        list.remove(list.size() - 1);
        dict.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
