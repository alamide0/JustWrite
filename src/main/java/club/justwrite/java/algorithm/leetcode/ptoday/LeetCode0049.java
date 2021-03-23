package club.justwrite.java.algorithm.leetcode.ptoday;

import java.util.*;

/**
 * @author ACC
 * @desc
 * @create 2020/12/14
 **/
public class LeetCode0049 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            int[] chars = new int[26];
            HashMap<String, List<String>> stringListHashMap = new HashMap<>();

            for (String str : strs) {
                for (char c : str.toCharArray()) {
                    chars[c - 'a']++;
                }

                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] != 0) {
                        stringBuilder.append((char) ('a' + i));
                        stringBuilder.append(chars[i]);
                        chars[i] = 0;
                    }
                }

                List<String> list = stringListHashMap.computeIfAbsent(stringBuilder.toString(), k -> new ArrayList<>());
                list.add(str);
            }

            return new ArrayList<>(stringListHashMap.values());
        }
    }
}
