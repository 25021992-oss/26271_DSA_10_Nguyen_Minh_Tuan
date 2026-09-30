package edu.princeton.cs.algs4;
import java.util.Stack;
public class QueueTwoStacks {
    /// try to use LinkedList to create Queue;
    class MyQueue {
        private Stack stack1;
        private Stack stack2;
        public MyQueue() {
            Stack<Integer> stack1 = new Stack<>() ;
            Stack<Integer> stack2 = new Stack<>();
            this.stack1= stack1;
            this.stack2 = stack2;
        }

        public void push(int x) {
            stack1.push(x);
        }

        public int pop() {
            if (!stack2.isEmpty()) {
                return (int) stack2.pop();
            }
            else {
                while (! stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return (int) stack2.pop();
            }
        }

        public int peek() {
            if (!stack2.isEmpty()) {
                return (int) stack2.peek();
            }
            else {
                while (! stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
                return (int) stack2.peek();
            }
        }

        public boolean empty() {
            return (stack1.isEmpty() && stack2.isEmpty());
        }
    }

}
