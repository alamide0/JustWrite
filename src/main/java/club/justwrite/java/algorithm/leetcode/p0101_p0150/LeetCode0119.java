package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.io.Printer;

import java.util.*;

/**
 * @author ACC
 * @desc
 * @create 2020/11/19
 **/
public class LeetCode0119 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.getRow(3));
    }

    private static class Solution {
        public List<Integer> getRow(int rowIndex) {

            LinkedList<Integer> queue = new LinkedList<>();

            rowIndex = rowIndex + 1;
            if (rowIndex >= 1) {
                queue.add(1);
            }

            if (rowIndex >= 2) {
                queue.add(1);
            }

            if (rowIndex > 2) {
                for (int i = 3; i <= rowIndex; i++) {
                    int count = queue.size();
                    int tmp = 0;
                    while (count > 0) {
                        queue.add(tmp + queue.peek());
                        tmp = queue.poll();
                        count--;
                    }
                    queue.add(1);
                }
            }


            return queue;

        }


    }
}