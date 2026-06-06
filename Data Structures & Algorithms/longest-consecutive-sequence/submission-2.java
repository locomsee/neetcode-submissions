class Solution {
    public int longestConsecutive(int[] nums) {
            
        if (nums == null || nums.length == 0)return 0;

        int longest = 1;
        int current = 1;

        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            
            if (nums[i] == nums[i - 1]) {
                continue; // duplicate //skip // don't reset
            } else if (nums[i] == nums[i - 1] + 1) {
                current++; // Increment current
            } else {
                current = 1; // Reset to 1
            }
            //Return the max between the two
            longest = Math.max(longest, current);
        }
        return longest;
    }
}
