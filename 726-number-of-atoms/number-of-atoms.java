import java.util.*;

public class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        int n = formula.length();
        int i = 0;
        
        while (i < n) {
            if (formula.charAt(i) == '(') {
                stack.push(new HashMap<>());
                i++;
            } else if (formula.charAt(i) == ')') {
                Map<String, Integer> top = stack.pop();
                i++;
                int start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = i > start ? Integer.parseInt(formula.substring(start, i)) : 1;
                for (String name : top.keySet()) {
                    int count = top.get(name);
                    stack.peek().put(name, stack.peek().getOrDefault(name, 0) + count * multiplicity);
                }
            } else {
                int start = i;
                i++;
                while (i < n && Character.isLowerCase(formula.charAt(i))) {
                    i++;
                }
                String name = formula.substring(start, i);
                start = i;
                while (i < n && Character.isDigit(formula.charAt(i))) {
                    i++;
                }
                int multiplicity = i > start ? Integer.parseInt(formula.substring(start, i)) : 1;
                stack.peek().put(name, stack.peek().getOrDefault(name, 0) + multiplicity);
            }
        }
        
        Map<String, Integer> countMap = stack.pop();
        StringBuilder sb = new StringBuilder();
        for (String name : new TreeMap<>(countMap).keySet()) {
            sb.append(name);
            int count = countMap.get(name);
            if (count > 1) {
                sb.append(count);
            }
        }
        return sb.toString();
    }
}
