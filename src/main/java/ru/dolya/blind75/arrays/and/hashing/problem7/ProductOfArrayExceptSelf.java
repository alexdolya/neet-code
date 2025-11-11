package ru.dolya.blind75.arrays.and.hashing.problem7;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 4, 6};
        System.out.println(Arrays.toString(productExceptSelf(arr)));

        int[] arr2 = new int[]{-1, 0, 1, 2, 3};
        System.out.println(Arrays.toString(productExceptSelf(arr2)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];

        int prod = 1;
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = prod;
            prod = prod * nums[i];
        }

        prod = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            postfix[i] = prod;
            prod = prod * nums[i];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * postfix[i];
        }
        return result;
    }
}
