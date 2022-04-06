package com.duglas.problems.romanToInteger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));

    }

    public static int romanToInt(String s) {
        Map<Character, Integer> mapRomanVals = new HashMap<>();
        mapRomanVals.put('I', 1);
        mapRomanVals.put('V', 5);
        mapRomanVals.put('X', 10);
        mapRomanVals.put('L', 50);
        mapRomanVals.put('C', 100);
        mapRomanVals.put('D', 500);
        mapRomanVals.put('M', 1000);

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (i > 0 && mapRomanVals.get(ch) > mapRomanVals.get(s.charAt(i - 1))) {
                res += mapRomanVals.get(ch) - 2 * mapRomanVals.get(s.charAt(i - 1));
            } else
                res += mapRomanVals.get(ch);
        }

        return res;
    }


}
