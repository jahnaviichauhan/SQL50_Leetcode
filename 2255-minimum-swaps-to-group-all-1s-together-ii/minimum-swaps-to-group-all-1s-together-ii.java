class Solution {
    public int minSwaps(int[] nums) {
         int totalOnes = 0;
        for (int num : nums) {
            totalOnes += num;
        }

        int n = nums.length;

        // If there are no 1's or all are 1's, no swaps needed
        if (totalOnes == 0 || totalOnes == n) {
            return 0;
        }

        // Extend the array to handle circular nature
        int[] extendedNums = new int[2 * n];
        System.arraycopy(nums, 0, extendedNums, 0, n);
        System.arraycopy(nums, 0, extendedNums, n, n);

        // Initial count of 0's in the first window of size totalOnes
        int currentZeros = totalOnes;
        for (int i = 0; i < totalOnes; i++) {
            currentZeros -= extendedNums[i];
        }
        int minZeros = currentZeros;

        // Slide the window across the extended array
        for (int i = 1; i < n; i++) {
            if (extendedNums[i - 1] == 0) {
                currentZeros -= 1;
            }
            if (extendedNums[i + totalOnes - 1] == 0) {
                currentZeros += 1;
            }

            minZeros = Math.min(minZeros, currentZeros);
        }

        return minZeros;
    }
}