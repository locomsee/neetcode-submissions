class Solution {
    // public boolean hasDuplicate(int[] nums) {
    //     if (nums.length == 0) {
    //         return false;
    //     }
    //     Map<Integer, Integer> numsMap = new HashMap<>();
    //     boolean hasDuplicate = false;

    //     for (int i = 0; i < nums.length; i++) {
    //         if (!numsMap.containsKey(nums[i])) {
    //             numsMap.put(nums[i], i);
    //         } else {
    //             hasDuplicate = true;
    //             break;
    //         }
    //     }
    //     return hasDuplicate;
    // }



    public boolean hasDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}