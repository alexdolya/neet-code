package ru.dolya.blind75.two.pointers.problem1;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Was it a car or a cat I saw?"));
        System.out.println(isPalindrome("tab a cat"));
        System.out.println(isPalindrome("No lemon, no melon"));
    }

    public static boolean isPalindrome(String s) {
        String result = s.replaceAll("[^A-Za-z0-9]", "");
        result = result.toLowerCase();

        int i = 0;
        int j = result.length() - 1;

        while (i < result.length() / 2) {
            if (result.charAt(i) != result.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
