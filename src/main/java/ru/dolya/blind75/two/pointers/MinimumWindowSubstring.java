package ru.dolya.blind75.two.pointers;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        System.out.println(minWindow("OUZODYXAZV", "XYZ"));
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(minWindow("a", "a"));
        System.out.println(minWindow("ab", "b"));
        System.out.println(minWindow("aa", "aa"));
        System.out.println(minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
        System.out.println(minWindow("a", "aa"));

    }

    public static String minWindow(String s, String t) {
        if (t.isEmpty() || t.length() > s.length()) {
            return "";
        }

        Map<Character, Integer> charsInT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charsInT.put(t.charAt(i), charsInT.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charCounts.put(t.charAt(i), 0);
        }

        int uniqCharCounter = 0;

        int left = 0;
        int right = 0;
        char[] stringArray = s.toCharArray();
        String result = null;

        while (right < s.length()) {
            if (charsInT.containsKey(stringArray[right])) {
                charCounts.put(stringArray[right], charCounts.getOrDefault(stringArray[right], 0) + 1);
                if (charCounts.get(stringArray[right]).equals(charsInT.get(stringArray[right]))) {
                    uniqCharCounter++;
                }
                if (uniqCharCounter == charsInT.size()) {
                    while (left <= right) {
                        String curResult = s.substring(left, right + 1);
                        if (result == null || result.length() > curResult.length()) {
                            result = curResult;
                        }
                        if (charsInT.containsKey(stringArray[left])) {
                            charCounts.put(stringArray[left], charCounts.get(stringArray[left]) - 1);
                            if (charCounts.get(stringArray[left]) < charsInT.get(stringArray[left])) {
                                uniqCharCounter--;
                                left++;
                                break;
                            }
                        }
                        left++;
                    }
                }
            }
            right++;
        }
        return result == null ? "" : result;
    }
}
