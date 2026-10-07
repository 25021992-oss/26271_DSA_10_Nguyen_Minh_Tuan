package edu.princeton.cs.algs4;

import java.util.ArrayList;
import java.util.List;

public class CountingSort1 {
    public static List<Integer> countingSort(List<Integer> arr) {
        int[] res= new int[100];
        for (int i = 0; i < 100 ; i++) {
            res[i] = 0;
        }
        for (int i =0 ; i< arr.size() ; i++) {
            res[arr.get(i)] +=1;
        }
        List<Integer> count = new ArrayList<>();
        for (int i = 0 ; i < res.length ; i++) {
            count.add(res[i]);
        }
        return count;

    }
}
