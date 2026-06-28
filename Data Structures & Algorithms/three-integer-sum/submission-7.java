class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        /*
         *Sort the array
         *for i & while loop
         */
        Arrays.sort(nums);
        List<List<Integer>> parenthreeSumList = new ArrayList();

        for (int i = 0;  i < nums.length - 2; i++) {
            //skip duplicates
            if( i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            while(left < right){
                int sum=nums[i] + nums[left] + nums[right];

                  if(sum == 0){
                   parenthreeSumList.add(Arrays.asList(nums[i], nums[left], nums[right]));
                      //skip duplicates 
                     while(left < right && nums[left] == nums[left + 1]){
                        left++; //increment
                     }
                     //skip duplicates
                     while(left < right && nums[right] == nums[right - 1]){
                        right--; //decrement
                     }
                     left++;
                     right--;

                  }else if(sum < 0){
                    left++;
                  }else{
                    right--;
                  }

            }
           
        }

        /*
         For large n, n² grows faster than n log n, so it dominates — meaning as n gets large, the n log n term becomes negligible by comparison.
         We drop the smaller term and report only the dominant one: Overall: O(n²)
        */

        return parenthreeSumList;
    }
}
