package ru.dolya.blind75.sliding.window;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("zxyzxyz"));

        System.out.println(lengthOfLongestSubstring("dvdf"));

        System.out.println(lengthOfLongestSubstring("xxxx"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> existingChars = new HashSet<>();
        int left = 0;
        int result = 0;
        int right = left;
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (existingChars.contains(rightChar)) {
                while (existingChars.contains(rightChar)) {
                    existingChars.remove(s.charAt(left));
                    left++;
                }
            }
            existingChars.add(rightChar);
            result = Math.max(result, right - left + 1);
            right++;
        }
        return result;
    }

}
