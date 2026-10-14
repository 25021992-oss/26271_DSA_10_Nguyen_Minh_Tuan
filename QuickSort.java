import java.io.*;
import java.util.*;

public class QuickSort {
    public static int partition(int[] arr , int low, int high) {
        int pivot = arr[high];
        int i= low -1;
        for (int j =low ; j < high ; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }
        int temp = arr[high];
        arr[high] = arr[i+1];
        arr[i+1] = temp;
        return i+1;

    }
    public static void quicksort(int[] arr,int  low,  int high) {
        if( low < high) {
            int pi = partition(arr,low,high);
            System.out.println(arr.toString().replaceAll("[\\[\\],]", ""));
            quicksort(arr,low,pi-1);
            quicksort(arr,pi+1,high);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        int low = 0 ;
        int high = arr.length-1;
        QuickSort.quicksort(arr,low,high);

    }
}
