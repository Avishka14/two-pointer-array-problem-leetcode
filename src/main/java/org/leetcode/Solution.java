package org.leetcode;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0;                       // pointer at the start
        int right = height.length - 1;      // pointer at the end
        int maxWater = 0;                   // keep the best area found

        while (left < right) {
            int width = right - left;                      // current width
            int minHeight = Math.min(height[left], height[right]); // container height
            int area = width * minHeight;                  // area formed by left & right
            maxWater = Math.max(maxWater, area);           // update max if this is better

            // move the pointer at the smaller height inward (only possible way to find a bigger area)
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] heights1 = {1,8,6,2,5,4,8,3,7};
        System.out.println(sol.maxArea(heights1));

        int[] heights2 = {1,1};
        System.out.println( sol.maxArea(heights2));
    }
}
