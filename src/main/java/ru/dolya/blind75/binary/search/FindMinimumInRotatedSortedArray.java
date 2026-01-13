package ru.dolya.blind75.binary.search;

public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println(findMin(new int[]{2, 3, 4, 5, 6, 1}));
        System.out.println(findMin(new int[]{3, 4, 5, 6, 1, 2}));
        System.out.println(findMin(new int[]{2, 1}));
    }

    public static int findMin(int[] nums) {
        if (nums.length == 1 || nums[nums.length - 1] > nums[0]) {
            return nums[0];
        }
        int left = 0;
        int right = nums.length - 1;
        int result = nums[0];
        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            result = Math.min(result, nums[left]);
            if (nums[mid] > nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
                result = Math.min(result, nums[mid]);
            }
        }
        return result;
    }
}
