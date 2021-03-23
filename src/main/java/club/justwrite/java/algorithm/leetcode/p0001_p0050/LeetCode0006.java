package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/11/26
 **/
public class LeetCode0006 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public String convert(String s, int numRows) {
            if(numRows <= 1) return  s;
            List<StringBuilder> lists = new ArrayList<>();

            for (int i = 0; i < numRows; i++) {
                lists.add(new StringBuilder());
            }

            char[] chars = s.toCharArray();
            int curRow = 0;
            boolean down = true;
            for (char aChar : chars) {
                lists.get(curRow).append(aChar);
                curRow = down ? curRow + 1 : curRow - 1;

                if (curRow == numRows - 1) down = false;

                if (curRow == 0) down = true;

            }

            StringBuilder stringBuilder = new StringBuilder();
            for (StringBuilder builder : lists) {
               stringBuilder.append(builder);
            }

            return stringBuilder.toString();
        }
    }
}