package ru.dolya.blind75.sliding.window;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        System.out.println(characterReplacement("BAAAB", 2));
        System.out.println(characterReplacement("AAABABB", 1));
        System.out.println(characterReplacement("AAAA", 4));
        System.out.println(characterReplacement("ABC", 2));
    }

    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = left;
        int result = 1;

        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            int maxFreq = Collections.max(map.values());
            while ((right - left + 1) - maxFreq > k) {
                map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
            result = Math.max(result, (right - left + 1));
            right++;
        }

        return result;
    }
}
