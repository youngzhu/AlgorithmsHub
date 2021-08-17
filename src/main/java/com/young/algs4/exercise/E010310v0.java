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
public class E010310v0 {
    public static void main(String[] args) {
        String infix = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";

        Stack<String> stack = new Stack<>();
        for (String s : infix.split(" ")) {
            if ("+".equals(s))
                stack.push(s);
            else if ("*".equals(s))
                stack.push(s);
            else if (")".equals(s))
                StdOut.print(stack.pop() + " ");
            else if ("(".equals(s))
                StdOut.print("");
            else
                StdOut.print(s + " ");
        }
    }
}
