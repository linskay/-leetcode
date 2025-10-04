class Solution {
    public int minStartValue(int[] nums) {
        int startValue = 1;

        while (true) {
            int total = startValue;
            boolean isValid = true;

            for (int num : nums) {
                total += num;

                if (total < 1) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                return startValue;
            } else {
                startValue += 1;
            }
        }
    }
}