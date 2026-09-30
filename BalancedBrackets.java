package edu.princeton.cs.algs4;
import java.util.Scanner;
import  java.util.Stack;
public class BalancedBrackets {
    public String isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i =0 ; i< s.length();i++) {
            char c = s.charAt(i);
            if ( c == '(' | c == '{' | c =='[') {
                stack.push(c);
            }
            else  {
                if (!stack.isEmpty()) {
                    char top = stack.pop();
                    if (c == ')' && top == '(') {}
                    else if (c == '}' && top =='{') {}
                    else if (c == ']' && top == '[') {}
                    else {
                        return "NO" ;
                    }
                }
                else {
                    return "NO";
                }
            }

        }
        if (stack.isEmpty()) {
            return "YES";
        }
        return "NO";
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleTextEditor text = new SimpleTextEditor("");
        int queries = sc.nextInt();
        sc.nextLine();
        for (int i = 0 ; i < queries ; i++) {
            String command = sc.nextLine();
            String[] parts = command.split("\\s+");
            if (parts[0].equals("1")) {
                text.append(parts[1]);
            } else if (parts[0].equals("2")) {
                int k = Integer.parseInt(parts[1]);
                text.delete(k);
            } else if (parts[0].equals("3")) {
                int k = Integer.parseInt(parts[1]);
                System.out.println(text.print(k));
            } else if (parts[0].equals("4")) {
                text.undo();
            }
        }

    }
}
