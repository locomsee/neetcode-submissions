class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Create a set
        Set<Character> set = new HashSet<>();

        int left=0;
        //Length of the maximum length
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char current = s.charAt(right);
            //Check if the set contains the char,if so remove it,increment left counter
            while(set.contains(current)){

                set.remove(s.charAt(left));
                left++;
            }
            set.add(current);
            maxLength=Math.max(maxLength,right-left+1);
        }

      return maxLength;
    }
}
