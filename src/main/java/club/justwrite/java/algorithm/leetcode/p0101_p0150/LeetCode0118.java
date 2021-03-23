package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.io.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/12/9
 **/
public class LeetCode0118 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.generate(5));
    }

    private static class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> ans = new ArrayList<>();
            if (numRows > 0) {
                ans.add(Arrays.asList(1));
            }

            if (numRows > 1) {
                ans.add(Arrays.asList(1, 1));
            }

            for (int i = 3; i <= numRows; i++) {
                int pre = 0;

                List<Integer> cur = new ArrayList<>();
                List<Integer> last = ans.get(i - 2);
                for (int j = 1; j < i; j++) {
                    cur.add(pre + last.get(j - 1));
                    pre = last.get(j - 1);
                }

                cur.add(1);

                ans.add(cur);
            }

            return ans;
        }
    }
}