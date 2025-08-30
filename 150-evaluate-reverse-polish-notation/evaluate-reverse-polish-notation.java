class Solution {
    private static final Map<
        String,
        BiFunction<Integer, Integer, Integer>
    > OPERATIONS = new HashMap<>();

    static {
        OPERATIONS.put("+", (a, b) -> a + b);
        OPERATIONS.put("-", (a, b) -> a - b);
        OPERATIONS.put("*", (a, b) -> a * b);
        OPERATIONS.put("/", (a, b) -> a / b);
    }

    public int evalRPN(String[] tokens) {
        int currentPosition = 0;
        int length = tokens.length; // We need to keep track of this ourselves.

        while (length > 1) {

            while (!OPERATIONS.containsKey(tokens[currentPosition])) {
                currentPosition++;
            }

            String operation = tokens[currentPosition];
            int number1 = Integer.parseInt(tokens[currentPosition - 2]);
            int number2 = Integer.parseInt(tokens[currentPosition - 1]);

            BiFunction<Integer, Integer, Integer> operator = OPERATIONS.get(
                operation
            );
            int value = operator.apply(number1, number2);
            tokens[currentPosition] = Integer.toString(value);

            delete2AtIndex(tokens, currentPosition - 2, length);
            currentPosition--;
            length -= 2;
        }

        return Integer.parseInt(tokens[0]);
    }

    private void delete2AtIndex(String[] tokens, int d, int length) {
        for (int i = d; i < length - 2; i++) {
            tokens[i] = tokens[i + 2];
        }
    }
}