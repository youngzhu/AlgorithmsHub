package com.young.algs4.exercise;

import com.young.algs4.ch01.Evaluate;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

/**
 * 对后序表达式进行求值
 *
 * @author youngzy
 * @since 2021-08-19
 */
public class E010311 {
    static double evaluatePostfix(String postfix) {
        Stack<Double> stack = new Stack<>();

        String[] a = postfix.split(" ");

        for (String s : a) {
            switch (s) {
                case "+":
                case "-":
                case "*":
                case "/":
                    stack.push(evaluate(stack, s));
                    break;
                default:
                    stack.push(Double.valueOf(s));
            }
        }

        return stack.pop();
    }

    private static double evaluate(Stack<Double> stack, String op) {
        double val1, val2;
        val2 = stack.pop();
        val1 = stack.pop();

        switch (op) {
            case "+":
                return val1 + val2;
            case "-":
                return val1 - val2;
            case "*":
                return val1 * val2;
            case "/":
                return val1 / val2;
            default:
                return 0;
        }
    }

    // 同一个表达式，中序和后序的结果应该一样
    public static void main(String[] args) {
        String infix = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        // 操作数的顺序影响结果，如 - /
        infix = "( 1 - ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        infix = "( 1 - ( ( 22 / 3 ) * ( 4 * 5 ) ) )";

        double infixVal = Evaluate.evaluate(infix);

        String postfix = E010310.infixToPostfix(infix);
        double postfixVal = evaluatePostfix(postfix);

        StdOut.printf("%s == %s", infixVal, postfixVal);
    }
}
