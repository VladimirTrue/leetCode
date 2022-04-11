package com.duglas.problems.IntegerToRoman;

import java.security.KeyStore;
import java.util.*;
import java.util.stream.Stream;

public class IntegerToRoman {
    public static void main(String[] args) {
        //   System.out.println(intToRoman(800));
        //      System.out.println(intToRoman(58));
//
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i + " " + intToRoman(i));
//        }
        //  System.out.println(intToRoman(8));
//        System.out.println("!!!" + intToRoman(1));
//        System.out.println("!!!" + intToRoman(6));
//        System.out.println("!!!" + intToRoman(3));
//        System.out.println("!!!" + intToRoman(4));
//        System.out.println("!!!" + intToRoman(5));
//        System.out.println("!!!" + intToRoman(6));
     //   System.out.println("!!!" + intToRoman(30));
        System.out.println("!!!" + intToRoman(2000));
        System.out.println("!!!" + intToRoman(8));
        System.out.println("!!!" + intToRoman(38));
        System.out.println("!!!" + intToRoman(3));
        System.out.println("!!!" + intToRoman(30));
        System.out.println("!!!" + intToRoman(48));
        System.out.println(intToRoman(2));
        System.out.println(intToRoman(900));
        System.out.println(intToRoman(800));
        System.out.println(intToRoman(1000));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(1009));

        System.out.println(intToRoman(4));
        System.out.println(intToRoman(1900));

        System.out.println(intToRoman(1));
        System.out.println(intToRoman(10));
        System.out.println(intToRoman(100));
        System.out.println(intToRoman(50));
        System.out.println(intToRoman(500));
    }

    public static String intToRoman(int num) {
        Map<Integer, String> mapNumToRoman = new LinkedHashMap<>();
        mapNumToRoman.put(1, "I");
        mapNumToRoman.put(5, "V");
        mapNumToRoman.put(10, "X");
        mapNumToRoman.put(50, "L");
        mapNumToRoman.put(100, "C");
        mapNumToRoman.put(500, "D");
        mapNumToRoman.put(1000, "M");

        //массив из значений числ
        int[] digitsArr = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        //билдер для сборка строки римских значений
        StringBuilder resStringBuilder = new StringBuilder();

        //преобразование массива чисел, в соответствии с их положением в num
        //1994
        //1 - 1000
        //9 - 900
        //9 - 90
        //4 - 4
        for (int i = 0; i < digitsArr.length; i++) {
            int bufNumsZero = digitsArr.length - 1 - i;
            while (bufNumsZero != 0) {
                digitsArr[i] = Integer.parseInt(digitsArr[i] + "0");
                bufNumsZero--;
            }
        }

        //отсекание из массива нулевых значений
        digitsArr = Arrays.stream(digitsArr).filter(s -> s > 0).toArray();

        for (int i = 0; i < digitsArr.length; i++) {
            int currNum = digitsArr[i];

            if (mapNumToRoman.get(currNum) != null) {
                resStringBuilder.append(mapNumToRoman.get(currNum));
            } else {
                int top = mapNumToRoman
                        .entrySet()
                        .stream()
                        .filter(s -> s.getKey() >= currNum)
                        .findFirst().orElse(mapNumToRoman.entrySet().stream().findFirst().get())
                        .getKey();

                int bot = mapNumToRoman
                        .entrySet()
                        .stream()
                        .filter(s -> s.getKey() < currNum)
                        .max(Comparator.comparingInt(Map.Entry::getKey))
                        .get()
                        .getKey();
                //   System.out.println("curr: " + currNum + " bot: " + bot + " top: " + top);
                int x = Integer.parseInt(String.valueOf(currNum).replaceFirst(".", "1"));
                int difference = (top - currNum) / x;
                if (difference == 1) {
                    resStringBuilder.append(mapNumToRoman.get(top - currNum));
                    resStringBuilder.append(mapNumToRoman.get(top));
                } else {
                    resStringBuilder.append(mapNumToRoman.get(bot));
                    if (mapNumToRoman.get(currNum - bot) != null) {
                        resStringBuilder.append(mapNumToRoman.get(currNum - bot));
                        continue;
                    }
                    for (int j = 0; j < (currNum - bot)/x; j++) {
                        resStringBuilder.append(mapNumToRoman.get(
                                mapNumToRoman
                                .entrySet()
                                .stream()
                                .filter(s -> s.getKey() <= currNum -bot).max(Comparator.comparingInt(Map.Entry::getKey)).orElse(mapNumToRoman.entrySet().stream().findFirst().get()).getKey())
                         //       .max(Comparator.comparingInt(Map.Entry::getKey))
                                // .orElse(mapNumToRoman.entrySet().stream().findFirst().get()).getKey()

                        );
                    }
                }

            }
        }


        return resStringBuilder.toString();
    }
}