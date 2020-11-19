package club.justwrite.java.algorithm.leetcode.p1101_p1150;

import club.justwrite.java.io.Printer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author ACC
 * @desc
 * @create 2020/10/28
 **/
public class LeetCode1122 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6}));
    }

    static class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int n : arr2) {
                map.put(n, 0);
            }

            int begin = 0;
            for (int i = 0; i < arr1.length; i++) {
                if (map.containsKey(arr1[i])) {
                    map.put(arr1[i], map.get(arr1[i]) + 1);
                    arr1[i] = -1;
                    begin++;
                }
            }
            Arrays.sort(arr1);

            int[] res = new int[arr1.length];
            int index = 0;

            for (int n : arr2) {
                for (int i = 0; i < map.get(n); i++) {
                    res[index++] = n;
                }
            }

            for (int i = begin; i < arr1.length; i++) {
                res[index++] = arr1[i];
            }

            return res;
        }
    }
}