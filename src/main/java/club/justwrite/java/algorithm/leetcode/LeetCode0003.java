package club.justwrite.java.algorithm.leetcode;

import club.justwrite.java.algorithm.leetcode.test.MainMethod;
import club.justwrite.java.algorithm.leetcode.test.Tester;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ACC
 * @desc
 * @create 2020/6/22
 **/
public class LeetCode0003 {
    public static void main(String[] args) {
        Solution solution = new Solution();

        Object[] params = new Object[]{
                "bbbaacbbbbbb", 3,
                "abcabcbb", 3,
                "bbbbb", 1,
                "pwwkew", 3
        };

        Tester.test(params, solution);

    }

    static class Solution {
        @MainMethod
        public int lengthOfLongestSubstring(String s) {
            Map<Character, Integer> map = new HashMap<>();
            int length = 0;
            int max = 0;
            int start = 0;
            for (int i = 0; i < s.length(); i++) {

                int index = map.getOrDefault(s.charAt(i), -1);

                if (index >= start) {//说明有重复了，更新数据
                    int tmp = map.get(s.charAt(i));
                    length -= tmp - start;
                    start = tmp + 1;
                } else {
                    length++;
                }

                if (length > max) {
                    max = length;
                }

                map.put(s.charAt(i), i);
            }

            return max;
        }
    }
}



