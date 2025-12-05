# Intuition
We want to find two lines that can hold the most water.
The amount of water depends on:
 - The **shorter** of the two heights (the water spills over the short one)
- The **distance** between the two lines
To maximize water, we start with the widest container (first and last line) and slowly move inward.

# Approach

1. Use two pointers:
- *`left`* at the start
- *`right`* at the end

2. Compute the area using:

`area = (right - left) * min(height[left], height[right])`

3. Update the maximum area found.

4. Move the pointer pointing to the smaller height, because moving the bigger one cannot increase the height limit.

5. Continue until `left` meets `right`.

# Code
```java []
class Solution {
    public int maxArea(int[] height) {
        int left = 0;                   
    int right = height.length - 1;  
    int maxWater = 0;             

    while (left < right) {

        int width = right - left;

        int minHeight = Math.min(height[left], height[right]);

        int area = width * minHeight;


        maxWater = Math.max(maxWater, area);


        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }

    return maxWater;
    }
}
```
