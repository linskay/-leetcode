class Solution {
    public int[] threeEqualParts(int[] arr) {
        int ones = 0;
        for (int num : arr) {
            ones += num;
        }
        if (ones % 3 != 0) return new int[]{-1, -1};
        if (ones == 0) return new int[]{0, arr.length - 1};

        int partOnes = ones / 3;
        int first = 0, second = 0, third = 0, cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cnt == 0) first = i;
                else if (cnt == partOnes) second = i;
                else if (cnt == 2 * partOnes) third = i;
                cnt++;
            }
        }

        while (third < arr.length && arr[first] == arr[second] && arr[first] == arr[third]) {
            first++;
            second++;
            third++;
        }

        if (third == arr.length) return new int[]{first - 1, second};
        return new int[]{-1, -1};
    }
}