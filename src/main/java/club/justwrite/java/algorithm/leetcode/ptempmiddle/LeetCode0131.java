package club.justwrite.java.algorithm.leetcode.ptempmiddle;

import club.justwrite.java.base.io.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/11/2
 **/
public class LeetCode0131 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.partition("afccfd"));
    }

    private static class Solution {
        public List<List<String>> partition(String s) {
            List<List<String>> lists = new ArrayList<>();
            backtrace(s.toCharArray(), 0, new ArrayList<>(), lists);
            return lists;
        }


        private void backtrace(char[] chars, int startIndex, List<String> res, List<List<String>> listList) {
            if (startIndex == chars.length) {
                listList.add(new ArrayList<>(res));
                return;
            }

            for (int i = startIndex; i < chars.length; i++) {
                if (isHui(chars, startIndex, i)) {
                    String value = String.valueOf(Arrays.copyOfRange(chars, startIndex, i + 1));
                    res.add(value);
                    backtrace(chars, i + 1, res, listList);
                    res.remove(value);
                }
            }
        }

        private boolean isHui(char[] chars, int start, int end) {


            while (start < end) {
                if (chars[start++] != chars[end--]) {
                    return false;
                }
            }

            return true;
        }
    }
}
