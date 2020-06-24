package club.justwrite.java.algorithm.leetcode.p0401_p0450;

import club.justwrite.java.io.Printer;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/6/8 3:21 PM
 **/
public class LeetCode0448 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Printer.print(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

    static class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int[] result = new int[nums.length + 1];
            List<Integer> list = new LinkedList<>();
            Arrays.fill(result, 0);

            for (int n : nums) {
                result[n] = 1;
            }

            int index = 0;
            for (int n : result) {
                if (n == 0 && index > 0) {
                    list.add(index);
                }
                index++;
            }

            return list;
        }
    }
}