package ru.dolya.blind75.arrays.and.hashing;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EncodeAndDecodeStrings {

    public static void main(String[] args) {
        List<String> strings = List.of("neet", "code", "love", "you");

        String encode = encode(strings);
        System.out.println(encode);

        System.out.println(decode(encode));
    }

    public static String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strs) {
            stringBuilder.append(string.length())
                    .append("$")
                    .append(string);
        }
        return stringBuilder.toString();
    }

    public static List<String> decode(String str) {
        if (str.isEmpty()) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '$') {
                stringBuilder.append(str.charAt(i));
            } else {
                int wordLength = Integer.parseInt(stringBuilder.toString());
                int beginIndex = i + 1;
                int endIndex = beginIndex + wordLength;
                String substring = str.substring(beginIndex, endIndex);
                result.add(substring);
                stringBuilder = new StringBuilder();
                i = endIndex - 1;
            }
        }
        return result;
    }
}
