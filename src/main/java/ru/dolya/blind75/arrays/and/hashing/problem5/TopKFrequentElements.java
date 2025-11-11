package ru.dolya.blind75.arrays.and.hashing.problem5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .mapToInt(Map.Entry::getKey)
                .limit(k)
                .toArray();
    }
}
