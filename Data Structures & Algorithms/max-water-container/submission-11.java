class Solution {
    public int maxArea(int[] heights) {
        //left
        int left = 0;

        //start from the right
        int right = heights.length - 1;

        //max Area
        int maxArea = 0;

         //Continue as long as left is less than right
        while (left < right) {
            //Calculate the width
            int width = right - left;
            //Calculate the height
            int height = Math.min(heights[right], heights[left]);

                     // Area of a Rectangle=length * width
            int area = height * width;

            maxArea = Math.max(area, maxArea);

            if (heights[left] < heights[right]) {
                //increment left index
                left++;
            } else {
                //decrement right index
                right--;
            }
        }

        return maxArea;
    }
}
