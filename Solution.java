import java.util.ArrayList;
/// 1.4.12///
public class Solution {
    public void  findNumbers(int[] arr1,int[] arr2) {
        int i = 0 ;
        int j = 0 ;
        ArrayList<Integer> res = new ArrayList<>();
        while (i < arr1.length & j < arr2.length) {
            if (arr1[i] == arr2[j]) {
                i +=1 ;
                j+=1;
                res.add(arr1[i]);
            } else if (arr1[i] <arr2[j]) {
                i+=1;
            }
            else {
                j+=1;
            }
        }
        for (int k = 0 ; k< res.size();k++) {
            System.out.print(res.get(k) + " ");
        }
    }
}
