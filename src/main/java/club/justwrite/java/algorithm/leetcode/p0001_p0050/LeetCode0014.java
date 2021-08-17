package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/6/15
 **/
public class LeetCode0014 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String res = solution.longestCommonPrefix(new String[]{"abc"});
        Printer.print(res);
    }

    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) return "";
            if(strs.length == 1) return strs[0];
            for (int i = 0; ; i++) {
                if (i >= strs[0].length()) {
                    return strs[0];
                }
                char now = strs[0].charAt(i);
                for (String s : strs) {
                    if (i >= s.length()) {
                        return s;
                    }
                    if (now != s.charAt(i)) {
                        return strs[0].substring(0, i);
                    }
                }
            }
        }
    }
}
