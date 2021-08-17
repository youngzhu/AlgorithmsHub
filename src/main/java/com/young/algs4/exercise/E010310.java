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

        Stack<String> ops = new Stack<>();
        Stack<String> vals = new Stack<>();

        String[] arr = infix.split(" ");
        for (String s : arr) {
            if ("(".equals(s)) ;// 忽略
            else if ("+".equals(s)) ops.push(s);
            else if ("-".equals(s)) ops.push(s);
            else if ("*".equals(s)) ops.push(s);
            else if ("/".equals(s)) ops.push(s);
            else if (")".equals(s)) {
                // 如果是右括号，弹出运算符和操作数，转后序表达式
                if (!vals.isEmpty()) {
                    queue.enqueue(vals.pop());
                }
                if (!vals.isEmpty()) {
                    queue.enqueue(vals.pop());
                }
                queue.enqueue(ops.pop());
            }
            else { // 其他的都是数字，压入操作数栈
                vals.push(s);
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
