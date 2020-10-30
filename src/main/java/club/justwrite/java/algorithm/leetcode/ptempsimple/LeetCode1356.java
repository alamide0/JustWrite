package club.justwrite.java.algorithm.leetcode.ptempsimple;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/10/28
 **/
public class LeetCode1356 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Printer.print(solution.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1}));
        Printer.print(solution.sortByBits(new int[]{10000, 10000}));
        Printer.print(solution.sortByBits(new int[]{2, 3, 5, 7, 11, 13, 17, 19}));
        Printer.print(solution.sortByBits(new int[]{10, 100, 1000, 10000}));

    }

    static class Solution {
        public int[] sortByBits(int[] arr) {
            int[] bits = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                bits[i] = bits(arr[i]);
            }

            quickSort(0, arr.length - 1, bits, arr);
            return arr;
        }

        private void quickSort(int start, int end, int[] bits, int[] arr) {
            if (start >= end) return;
            int pivot = bits[start];
            int i = start, j = end;

            while (i < j) {
                while (i < j && bits[j] > pivot) j--;
                while (i < j && bits[i] < pivot) i++;

                if (bits[i] == bits[j] && i < j) {
                    if (arr[i] < arr[j]) {
                        int tmm = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmm;
                    }
                    i++;
                } else {
                    int tmp = bits[i];
                    bits[i] = bits[j];
                    bits[j] = tmp;

                    int tmm = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmm;
                }
            }

            quickSort(start, i - 1, bits, arr);
            quickSort(i + 1, end, bits, arr);
        }

        private int bits(int n) {
            String bs = Integer.toBinaryString(n);

            int count = 0;
            for (int i = 0; i < bs.length(); i++) {
                if (bs.charAt(i) == '1') count++;
            }

            return count;
        }
    }
}
