package club.justwrite.java.algorithm.leetcode.p1201_p1250;

import club.justwrite.java.io.Printer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author ACC
 * @desc
 * @create 2020/10/28
 **/
public class LeetCode1207 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        Printer.print(solution.uniqueOccurrences(new int[]{1, 2}));
        Printer.print(solution.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for (int n : arr) {
                hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
            }

            HashSet<Integer> hashSet = new HashSet<>();

            for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
                if (hashSet.contains(entry.getValue())) return false;
                hashSet.add(entry.getValue());
            }

            return true;
        }
    }
}