package number_640;

import java.util.Stack;

public class Solution {
    public String solveEquation(String equation) {
        Stack<Character> xStack = new Stack<>();
        Stack<Character> nStack = new Stack<>();

        int prev = 0;
        int xSum = 0;
        int nSum = 0;
        for (int i = 0; i < equation.length(); i++) {
            if (equation.charAt(i) == '+' || equation.charAt(i) == '-' || equation.charAt(i) == '=') {
                String tmp = equation.substring(prev, i);
                if (tmp.contains("x")) {
                    int xIndex = tmp.indexOf('x');
                    if (tmp.length() == 1) {
                        xSum += 1;
                    } else {
                        int xValue = Integer.parseInt(tmp.substring(0, xIndex));
                        if (xStack.isEmpty()) {
                            xSum += xValue;
                        } else {
                            xSum = addSum(xSum, xValue, xStack.pop());
                        }
                    }
                    if (equation.charAt(i) != '=') {
                        xStack.add(equation.charAt(i));
                    }
                } else {
                    int value = Integer.parseInt(equation.substring(prev, i));
                    if (nStack.isEmpty()) {
                        nSum += value;
                    } else {
                        nSum = addSum(nSum, value, nStack.pop());
                    }
                    if (equation.charAt(i) != '=') {
                        nStack.add(equation.charAt(i));
                    }
                }
                prev = i + 1;
            }
        }
        return null;

    }

    private int addSum(int sum, int number, char symbol) {
        int res = 0;
        switch (symbol) {
            case '+' :
                res = sum + number;
                break;
            case '-':
                res = sum - number;
                break;
            default:
        }
        return res;
    }

    public String solveEquation1(String equation) {
        int xCoefficient = 0, constant = 0;
        equation = equation + "*";

        Integer number = null;
        int sign = 1, left = 1;
        for (char c : equation.toCharArray()) {
            if ('0' <= c && c <= '9') {
                number = number == null ? c - '0' : number * 10 + c - '0';
            } else if (c == 'x') {
                xCoefficient += left * sign * (number == null ? 1 : number);
                sign = 1;
                number = null;
            } else if (c == '+' || c == '-' || c == '*') {
                if (number != null) {
                    constant += left * sign * number;
                    number = null;
                }
                sign = c == '+' ? 1 : -1;
            } else {
                if (number != null) {
                    constant += left * sign * number;
                    number = null;
                }
                left = -1;
                sign = 1;
            }
        }

        if (xCoefficient == 0 && constant == 0) {
            return "Infinite solutions";
        } else if (xCoefficient == 0 && constant != 0) {
            return "No solution";
        } else {
            return "x=" + String.valueOf(-constant / xCoefficient);
        }
    }

    public static void main(String[] args) {
        new Solution().solveEquation("3+x+5-3+x=6+x-2");
    }
}
