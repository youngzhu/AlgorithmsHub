package com.young.algs4.exercise;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 1.3.10 将中序表达式转为后序表达式
 *
 * @author youngzy
 * @since 2021-08-16
 */
public class E010310 {
    public static String infixToPostfix(String infix) {
        Queue<String> queue = new Queue<>();

        Stack<String> stack = new Stack<>();

        String[] temp = new String[3];
        String[] arr = infix.split(" ");

        for (String s : arr) {
            if (")".equals(s)) {
                int count = 0;

                while (!stack.isEmpty() && !"(".equals(stack.peek())) {
                    temp[count++] = stack.pop();
                }

                if (count > 0)
                    stack.pop();

                switch (count) {
                    case 3:
                        queue.enqueue(temp[2]);
                        queue.enqueue(temp[0]);
                        queue.enqueue(temp[1]);
                        break;
                    case 2:
                        queue.enqueue(temp[1]);
                        queue.enqueue(temp[0]);
                        break;
                    case 1:
                        queue.enqueue(temp[0]);
                        break;
                    default:

                }

            } else {
                stack.push(s);
            }
        }

        return queue.toString();
    }

    public static void main(String[] args) {
        String infix = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String postfix = infixToPostfix(infix);
        StdOut.println(postfix);
    }
}
