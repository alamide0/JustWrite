package club.justwrite.java.algorithm.leetcode.p0401_p0450;

import club.justwrite.java.io.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ACC
 * @desc 回溯 简单题
 * @create 2020/11/2
 **/
public class LeetCode0401 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.readBinaryWatch(5));
    }

    private static class Solution {
        public List<String> readBinaryWatch(int num) {

            List<String> stringList = new ArrayList<>();

            for (int i = 0; i <= 4; i++) {
                if (num - i > 6) continue;
                List<String> hour = new ArrayList<>();
                backtrace(i, new int[4], 0, hour);

                List<String> minute = new ArrayList<>();
                backtrace(num - i, new int[6], 0, minute);

                for (String h : hour) {
                    for (String m : minute) {
                        if (m.length() == 1) {
                            m = "0" + m;
                        }
                        stringList.add(h + ":" + m);
                    }
                }

            }

            return stringList;
        }

        private void backtrace(int num, int[] binary, int startIndex, List<String> stringList) {

            if (num == 0) {
                StringBuilder sb = new StringBuilder();
                for (int val : binary) {
                    sb.append(val);
                }
                int tmp = Integer.parseInt(sb.toString(), 2);
                if ((tmp > 11 && binary.length == 4) || (tmp > 59 && binary.length == 6)) return;
                stringList.add(Integer.toString(tmp));
                return;
            }

            for (int i = startIndex; i < binary.length; i++) {
                if (binary.length - i < num - 1) continue;
                binary[i] = 1;
                backtrace(num - 1, binary, i + 1, stringList);
                binary[i] = 0;
            }
        }
    }
}