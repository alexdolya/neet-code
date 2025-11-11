package ru.dolya.blind75.arrays.and.hashing.problem1;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 3};
        System.out.println(hasDuplicate(arr));
    }

    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
