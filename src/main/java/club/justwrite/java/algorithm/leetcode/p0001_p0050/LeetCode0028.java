package club.justwrite.java.algorithm.leetcode.p0001_p0050;

import club.justwrite.java.algorithm.leetcode.ListNode;
import club.justwrite.java.algorithm.leetcode.TreeNode;

/**
 * @author ACC
 * @desc
 * @create 2020/10/22
 **/
public class LeetCode0028 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int strStr(String haystack, String needle) {
            if ("".equals(needle)) return 0;
            for (int i = 0; i <= haystack.length() - needle.length(); i++) {
                for (int j = 0; j < needle.length(); j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        break;
                    }
                    if (j == needle.length() - 1) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
}