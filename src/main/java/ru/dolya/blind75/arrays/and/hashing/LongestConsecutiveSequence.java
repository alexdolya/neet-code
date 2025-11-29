package ru.dolya.blind75.arrays.and.hashing;

import java.util.*;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 20, 4, 10, 3, 4, 5};

        System.out.println(longestConsecutive(nums));

        int[] nums2 = new int[]{0, 0};

        System.out.println(longestConsecutive(nums2));

    }

    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int maxSeq = 1;
        for (int num : nums) {
            int currentMaxSeq = 1;
            int currentNum = num + 1;
            while (set.contains(currentNum)) {
                currentMaxSeq++;
                currentNum++;
            }
            if (currentMaxSeq > maxSeq) {
                maxSeq = currentMaxSeq;
            }
        }

        return maxSeq;
    }
}
