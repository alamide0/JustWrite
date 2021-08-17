package club.justwrite.java.algorithm.leetcode.p0651_p0700;


import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/6
 **/
public class LeetCode0682 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.calPoints(new String[]{"5", "2", "C", "D", "+"}));
        Printer.print(solution.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
        Printer.print(solution.calPoints(new String[]{"5"}));
    }

    private static class Solution {
        public int calPoints(String[] ops) {
            int[] stack = new int[ops.length];
            int pointer = -1;

            for (String op : ops) {
                switch (op) {
                    case "C":
                        pointer--;
                        break;
                    case "D":
                        stack[pointer + 1] = stack[pointer] * 2;
                        pointer++;
                        break;
                    case "+":
                        stack[pointer + 1] = stack[pointer - 1] + stack[pointer];
                        pointer++;
                        break;
                    default:
                        stack[++pointer] = Integer.parseInt(op);
                        break;
                }
            }

            int sum = 0;

            for (int i = 0; i <= pointer; i++) {
                sum += stack[i];
            }

            return sum;
        }
    }
}