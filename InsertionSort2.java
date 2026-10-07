package edu.princeton.cs.algs4;

import java.util.List;
import java.util.stream.Collectors;

public class InsertionSort2 {
    public static void insertionSort2(int n, List<Integer> arr) {
        for (int i = 1 ; i< arr.size(); i++) {
            int temp = arr.get(i);
            boolean oke = false;
            for (int j = i-1; j > -1; j -- ) {
                if (temp < arr.get(j)) {
                    arr.set(j+1,arr.get(j));
                }
                else {
                    arr.set(j+1,temp);
                    oke = true;
                    break;
                }
            }
            if (!oke) {
                arr.set(0,temp);
            }
            System.out.println(arr);
        }

    }
}
