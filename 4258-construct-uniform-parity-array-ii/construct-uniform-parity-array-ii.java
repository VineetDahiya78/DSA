class Solution {
    public boolean uniformArray(int[] nums1) {

        int minOdd = Integer.MAX_VALUE;

        // Find smallest odd number
        for (int num : nums1) {
            if (num % 2 != 0) {
                minOdd = Math.min(minOdd, num);
            }
        }

        // If there is no odd number,
        // all numbers are even
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }

        // Try to make every even number odd
        for (int num : nums1) {
            if (num % 2 == 0 && num < minOdd) {
                return false;
            }
        }

        return true;
    }
}