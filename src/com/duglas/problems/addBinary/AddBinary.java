package com.duglas.problems.addBinary;

import java.math.BigInteger;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("111", "11"));
        //   1010
        System.out.println(addBinary("100", "110010"));
        //110110
        System.out.println(addBinary("11", "1"));
        //100
        System.out.println(addBinary("1010", "1011"));
        //10101
    }

    public static String addBinary(String a, String b) {
        BigInteger num1 = new BigInteger(a, 2);
        BigInteger num2 = new BigInteger(b, 2);
        num1 = num1.add(num2);
        String sum = num1.toString(2);
        return sum;
    }


}