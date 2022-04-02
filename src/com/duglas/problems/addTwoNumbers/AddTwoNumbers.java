package com.duglas.problems.addTwoNumbers;

import java.util.*;

/*
плохое решение, есть проще, если делать фиктивную голову списка
и проверять на наличе следующего узла переменной через while, оба входящих списка
*/
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(4, listNode1);
        ListNode listNode3 = new ListNode(2, listNode2);

        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(4, listNode4);
        ListNode listNode6 = new ListNode(6, listNode5);
        ListNode listNode7 = new ListNode(5, listNode6);
        //System.out.println(listNode1.next);
//        addTwoNumbers(listNode3, listNode6);
        System.out.println(addTwoNumbers(listNode3, listNode7).val);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> l1List = getListOfListNodeVals(l1);
        List<Integer> l2List = getListOfListNodeVals(l2);
        List<Integer> sumList;
        sumList = getSumOfListsOfLists(l1List, l2List);

        List<ListNode> resListListNodes = new ArrayList<>();
        for (int i = sumList.size() - 1; i >= 0; i--) {
            if (resListListNodes.isEmpty()) {
                resListListNodes.add(0, new ListNode(sumList.get(i)));
                continue;
            }
            resListListNodes.add(0, new ListNode(
                    sumList.get(i),
                    resListListNodes.get(0)));
        }

        return resListListNodes.get(0);
    }


    public static List<Integer> getSumOfListsOfLists(List<Integer> first, List<Integer> second) {
        List<Integer> list = new ArrayList<>();
        int buf = 0;
        for (int i = 0; i < (first.size() > second.size() ? first.size() : second.size()); i++) {
            int resVal = (first.size() > i ? first.get(i) : 0) + (second.size() > i ? second.get(i) : 0) + buf;
            buf = 0;
            if (resVal >= 10) {
                list.add(Integer.parseInt(String.valueOf(resVal).split("")[1]));
                buf = Integer.parseInt(String.valueOf(resVal).split("")[0]);
            } else {
                list.add(resVal);
            }
        }
        if (buf > 0) list.add(buf);
        return list;
    }

    public static List<Integer> getListOfListNodeVals(ListNode listNode) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (listNode == null) break;
            list.add(listNode.val);
            listNode = listNode.next;
        }
        return list;
    }

}
