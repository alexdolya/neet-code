package ru.dolya.blind75.binary.search;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(search(new int[]{3, 4, 5, 6, 1, 2}, 6));
        System.out.println(search(new int[]{5, 1, 2, 3, 4}, 1));
        System.out.println(search(new int[]{3, 5, 6, 0, 1, 2}, 5));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] == target) {
                return left;
            }
            if (nums[right] == target) {
                return right;
            }
            if ((target > nums[mid] && target > nums[left])
                    || (target < nums[mid] && nums[left] > nums[mid])) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}