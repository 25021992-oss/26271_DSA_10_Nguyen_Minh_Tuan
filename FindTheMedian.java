import java.util.Scanner;

public class FindTheMedian {
    public static int quickselect(int[] arr, int low, int high,int k) {
        if ( low == high) {
            return arr[low];
        }
        int pi = partion(arr,low,high);
        if (pi==k-1) {
            return arr[k-1];
        } else if (pi > k) {
            return quickselect(arr,low,pi-1,k);
        }
        else {
            return quickselect(arr,pi+1,high,k);
        }
    }
    public static int partion(int[] arr, int low, int high) {
        int k = low;
        for (int i = low; i < high ; i++) {
            if (arr[i] < low) {
                exch(arr,k,i);
                k++;
            }
        }
        exch(arr,high,k);
        return k;
    }
    public static   void exch(int[] arr,int u , int v) {
        int temp = arr[u];
        arr[u] = arr[v];
        arr[v] =temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = n /2 ;
        int[] arr = new int[n];
        for (int i =0 ; i< n ;i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(FindTheMedian.quickselect(arr,0,n-1,k));

    }
}
