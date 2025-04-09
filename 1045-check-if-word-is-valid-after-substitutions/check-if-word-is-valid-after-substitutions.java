public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 3 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == 'c') {
                if (stack.size() < 2 || stack.pop() != 'b' || stack.pop() != 'a') {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }

        return stack.isEmpty();
    }
}