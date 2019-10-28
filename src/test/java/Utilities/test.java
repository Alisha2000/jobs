package Utilities;

import java.util.*;

public class test {

    public static int findMaxSum(List<Integer> list) {
        Collections.sort(list);
        int sum=list.get(list.size()-1) + list.get(list.size()-2);
        return sum;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 9, 7, 11);
        System.out.println(findMaxSum(list));
    }

}
