package edu.princeton.cs.algs4;

public class SimpleTextEditor {
    private Stack stack;
    private String s ;
    public SimpleTextEditor(String s) {
        this.s = s ;
        Stack<String> stack = new Stack<>();
        this.stack = stack;
    }
    public void append(String text) {
        stack.push(s);
        s += text ;
    }
    public void delete(int k) {
        stack.push(s) ;
        if (k >= s.length()) { s ="";}
        else {
            s = s.substring(0, s.length() - k);
        }
    }
    public char print(int k) {
        if (k > s.length()) {
            return ' ';
        }
        else {
            return s.charAt(k-1);
        }
    }
    public void undo() {
        if (!stack.isEmpty()) {
            String prev = (String) stack.pop();
            s = prev;
        }
        else {
            s ="";
        }
    }
}

