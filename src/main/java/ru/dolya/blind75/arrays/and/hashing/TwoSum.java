package ru.dolya.blind75.arrays.and.hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3, 4, 5, 6}, 7)));
        System.out.println(Arrays.toString(twoSum(new int[]{5, 5}, 10)));
        System.out.println(Arrays.toString(twoSum(new int[]{1, 3, 4, 2}, 6)));

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{Math.min(i, map.get(diff)), Math.max(i, map.get(diff))};
            }
            map.put(nums[i], i);
        }
        return null;
    }

}
