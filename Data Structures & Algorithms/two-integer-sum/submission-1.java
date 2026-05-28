class Solution {
    public int[] twoSum(int[] nums, int target) {
        /*
           *  Input:
               nums = [3,4,5,6], target = 7
               Output:[0,1]
           *
           *
           * */

        // complement,index
        Map<Integer, Integer> mapComplementIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 3, 4, 5
            // 4, 3, 2
            Integer complement = target - nums[i];

            if (mapComplementIndex.containsKey(nums[i])) {
                return new int[] {mapComplementIndex.get(nums[i]), i};
            } else {
                mapComplementIndex.put(complement, i);
            }
        }

        return new int[] {-1, -1};
    }
}
