package edu.princeton.cs.algs4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InsertionSort {
    public static void insertionSort1(int n, List<Integer> arr) {
        if (arr.size() == 0 | arr.size() ==1 ) {System.out.println(arr);}
        else {
            int temp = arr.get(arr.size() -1);
            boolean  oke = false;
            for (int i = arr.size() -2 ; i > -1; i--) {
                if (temp < arr.get(i)) {
                    arr.set(i+1, arr.get(i));
                    System.out.println(arr);
                }
                else {
                    arr.set(i+1,temp);
                    oke = true;
                    System.out.println(arr);
                    break;
                }
            }
            if (!oke) {
                arr.set(0,temp);
                System.out.println(arr);
            }

        }
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>(n);
        for (int i = 0 ; i< n ; i ++) {
            arr.add(sc.nextInt());
        }
        InsertionSort.insertionSort1(n,arr);
    }
}
