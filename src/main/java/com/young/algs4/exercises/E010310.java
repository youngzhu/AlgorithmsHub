package com.young.algs4.exercises;

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

        Stack<String> opStack = new Stack<>();

        String[] arr = infix.split(" ");

        for (String s : arr) {
            if ("(".equals(s)) ;//
            else if ("+".equals(s)) opStack.push(s);
            else if ("-".equals(s)) opStack.push(s);
            else if ("*".equals(s)) opStack.push(s);
            else if ("/".equals(s)) opStack.push(s);
            else if (")".equals(s)) queue.enqueue(opStack.pop());
            else queue.enqueue(s);
        }

        return queue.toString();
    }

    public static void main(String[] args) {
        String infix = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        String postfix = infixToPostfix(infix);
        StdOut.println(postfix);
    }
}
