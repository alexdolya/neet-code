package ru.dolya.blind75.arrays.and.hashing.problem4;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[] {"act","pots","tops","cat","stop","hat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> value = map.getOrDefault(key, new ArrayList<>());
            value.add(str);
            map.put(key, value);
        }
        List<List<String>> result = new ArrayList<>();
        map.forEach((a, b) -> result.add(b));
        return result;
    }
}
