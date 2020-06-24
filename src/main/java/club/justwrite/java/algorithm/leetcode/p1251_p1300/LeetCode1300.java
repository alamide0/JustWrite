package club.justwrite.java.algorithm.leetcode.p1251_p1300;

import club.justwrite.java.io.Printer;

import java.util.Arrays;

/**
 * @author ACC
 * @desc
 * @create 2020/6/14
 **/
public class LeetCode1300 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {60864, 25176, 27249, 21296, 20204};
        Printer.print(solution.findBestValue(arr, 0));

    }

    static class Solution {
        public int findBestValue(int[] arr, int target) {
            Arrays.sort(arr);
            int res = 0;
            int sum = 0;
            int startIndex = 0;

            for (int i = startIndex; i < arr.length; i++) {
                res = arr[i];
                sum += arr[i];
                if (sum + res * (arr.length - i - 1) >= target) {
                    if (i - 1 < 0) {//说明结果值需要比第一个数还要小
                        int average = target / arr.length;

                        if (Math.abs(average * arr.length - target) < Math.abs((average + 1) * arr.length - target)) {
                            return average;
                        } else {
                            return average + 1;
                        }
                    } else {
                        int d = Integer.MAX_VALUE;
                        for (int j = arr[i - 1]; j <= arr[i]; j++) {
                            int s = sum - arr[i] + j * (arr.length - i) - target;
                            int abs = Math.abs(s);
                            if (d > abs) {
                                d = abs;
                                res = j;
                            }
                            if (s > 0) break;
                        }
                    }
                    break;
                }
            }

            return res;

        }
    }
}

