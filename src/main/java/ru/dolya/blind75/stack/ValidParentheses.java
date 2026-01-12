package ru.dolya.blind75.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("([{}])"));
        System.out.println(isValid("[(])"));
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        Set<Character> pushSet = Set.of('{', '[', '(');
        Set<Character> popSet = Set.of('}', ']', ')');

        Map<Character, Character> map = Map.of('{', '}', '(', ')', '[', ']');

        for (Character c : s.toCharArray()) {
            if (pushSet.contains(c)) {
                stack.push(c);
            }
            if (popSet.contains(c)) {
                Character peek = stack.peek();
                if (peek == null) {
                    return false;
                }
                Character c1 = map.get(peek);
                if (c.equals(c1)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
