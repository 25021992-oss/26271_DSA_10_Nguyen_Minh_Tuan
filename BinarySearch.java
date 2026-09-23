///  1.4.10 ///
public class BinarySearch {
    public int Solution(int[] arr,int key) {
        int idx = -1 ;
        int left = 0;
        int right = arr.length -1 ;
        while (left <= right) {
            int mid = (left +right) / 2 ;
            if (arr[mid] > key) {
                right = mid-1;
            } else if (arr[mid] < key) {
                left = mid+1;
            }
            else {
                idx = mid ;
                right = mid-1 ;
            }
        }
        return idx;
    }
}
