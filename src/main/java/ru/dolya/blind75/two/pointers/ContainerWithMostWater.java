package ru.dolya.blind75.two.pointers;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 7, 2, 5, 4, 7, 3, 6}));
    }

    public static int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int area = 0;
        while (left < heights.length && right >= 0) {
            int length = right - left;
            int height = Math.min(heights[left], heights[right]);

            area = Math.max(area, length * height);

            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
