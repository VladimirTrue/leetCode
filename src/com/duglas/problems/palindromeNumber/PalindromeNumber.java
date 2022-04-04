package com.duglas.problems.palindromeNumber;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-112));
        System.out.println(isPalindrome(121));
        System.out.println(isPalindrome(1221));
        System.out.println(isPalindrome(133));
    }

    public static boolean isPalindrome(int x) {
        int res;
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(x));
            res = Integer.parseInt(sb.reverse().toString());
        } catch (NumberFormatException e){
            return false;
        }
        if (x == res) return true;
        return false;
    }

}
