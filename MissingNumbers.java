import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'missingNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER_ARRAY brr
     */
     /* Solution 1 : Using HashTable 
        List<Integer> res = new ArrayList<Integer>();
        HashMap<Integer,Integer> freq = new HashMap<>();
        for (int i = 0 ; i< brr.size(); i++) {
            if (freq.containsKey(brr.get(i))) {
                int val = freq.get(brr.get(i));
                freq.put(brr.get(i),val+1);
            }
            else {
                freq.put(brr.get(i),1);
            }
        }
        for (int i = 0 ; i< arr.size(); i++) {
            int val = freq.get(arr.get(i));
            freq.put(arr.get(i),val-1);
        }
        for (Map.Entry<Integer,Integer> element : freq.entrySet()) {
            int key = element.getKey();
            if (freq.get(key) != 0) {
                res.add(key);
            }
        }
        Collections.sort(res);
        return res;

        */ 
    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        /* Solution 2 : using sort + two pointers 
        Collections.sort(arr);
        Collections.sort(brr);

        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (j < brr.size()) {
            if (i < arr.size() && arr.get(i).equals(brr.get(j))) {
                i++;
                j++;
            } else {
                int missing = brr.get(j);
                if (result.isEmpty() || !result.get(result.size() - 1).equals(missing)) {
                    result.add(missing);
                }
                j++;
            }
        }
        return result;
        */ 
        /// Solution 3 : using counting sort 
        int minVal = Collections.min(brr);
        int[] count = new int[101];

        for (int num : brr) {
            count[num - minVal]++;
        }
        for (int num : arr) {
            count[num - minVal]--;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                result.add(i + minVal);
            }
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.missingNumbers(arr, brr);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
