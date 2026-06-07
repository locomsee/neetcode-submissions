class Solution {
    public int longestConsecutive(int[] nums) {
        /*
         1. Check if array is null/empty
         2. Var longest,current
         3. Math.max(longest,current);
        */

        if (nums == null || nums.length == 0)
            return 0;
        Arrays.sort(nums);
        int current = 1;
        int longest = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                current++;
            } else {
                current=1;
            }
            longest = Math.max(longest, current);
        }

        return longest;
    }
}
