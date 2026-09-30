package edu.princeton.cs.algs4;

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

class EqualStacks {

    /*
     * Complete the 'equalStacks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY h1
     *  2. INTEGER_ARRAY h2
     *  3. INTEGER_ARRAY h3
     */

    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
        Stack<Integer>stack1 = addAllStack(h1);
        Stack<Integer> stack2 = addAllStack(h2);
        Stack<Integer> stack3 = addAllStack(h3);
        int sum1 = sum(h1);
        int sum2 = sum(h2);
        int sum3 = sum(h3);
        int min_sum  = Math.min(Math.min(sum1,sum2),sum3);
        while ((sum1 != sum2 | sum2 != sum3 | sum1 != sum3 ) && !stack1.isEmpty()  && !stack2.isEmpty() && !stack3.isEmpty()) {
            if (sum1 > min_sum) {
                int number1  = stack1.pop();
                sum1 -= number1 ;
            }
            if (sum2 > min_sum) {
                int number2 = stack2.pop();
                sum2 -= number2 ;
            }
            if (sum3  > min_sum) {
                int number3 = stack3.pop();
                sum3 -= number3 ;
            }
            int min_sum_loop  = Math.min(Math.min(sum1,sum2),sum3);
            min_sum = Math.min(min_sum_loop,min_sum);
        }
        return min_sum;

    }
    public  static int sum(List<Integer> arr) {
        int sum = 0 ;
        for (int i =0 ; i< arr.size(); i++) {
            sum += arr.get(i);
        }
        return sum ;
    }
    public static Stack addAllStack(List<Integer> arr) {
        Stack<Integer> stack = new Stack<>();
        for (int i =arr.size()-1; i> -1; i--) {
            stack.push(arr.get(i));
        }
        return stack;
    }
}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n1 = Integer.parseInt(firstMultipleInput[0]);

        int n2 = Integer.parseInt(firstMultipleInput[1]);

        int n3 = Integer.parseInt(firstMultipleInput[2]);

        List<Integer> h1 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h2 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> h3 = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = EqualStacks.equalStacks(h1, h2, h3);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
