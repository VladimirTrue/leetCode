package com.duglas.problems.twoSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        //лист для обработки входящего массива через stream
        List<Integer> list = new ArrayList<>();
        //Итогововый массив, с индесами подходящих значений
        int[] res = new int[2];

        //заполеняем лист
        Arrays.stream(nums).forEach(s -> list.add(s));
        for (int i = 0; i < list.size(); i++) {
            if (list.contains(target - nums[i])) {
                res[0] = list.indexOf(target - nums[i]);
                res[1] = i;
                if (res[0] != res[1]) break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = twoSum(new int[]{2, 7, 1, 5}, 9);
        for (Integer i : res) {
            System.out.println(i);
        }
    }
}
