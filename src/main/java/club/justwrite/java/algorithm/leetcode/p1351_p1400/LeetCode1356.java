package club.justwrite.java.algorithm.leetcode.p1351_p1400;

import club.justwrite.java.base.io.Printer;

import java.util.*;

/**
 * @author ACC
 * @desc
 * @create 2020/10/28
 **/
public class LeetCode1356 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Printer.print(solution.sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}));
        Printer.print(solution.sortByBits(new int[]{1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1}));
//        Printer.print(solution.sortByBits(new int[]{10000, 10000}));
//        Printer.print(solution.sortByBits(new int[]{2, 3, 5, 7, 11, 13, 17, 19}));
//        Printer.print(solution.sortByBits(new int[]{10, 100, 1000, 10000}));


    }

    static class Solution {


        public int[] sortByBits(int[] arr) {

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.bitCount(arr[i]) * 100_000 + arr[i];
            }

            Arrays.sort(arr);

            for (int i = 0; i < arr.length; i++) {
                arr[i] = arr[i] % 100_000;
            }
            return arr;
        }

        public int[] sortByBits3(int[] arr) {


            List<Integer> list = new ArrayList<>(arr.length);

            for (int n : arr) {
                list.add(n);
            }

            int[] bs = new int[10001];
            for (int i = 0; i < bs.length; i++) {
                bs[i] = bs[i >> 1] + (i & 1);
            }

            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {

                    if (bs[o1] != bs[o2]) {
                        return bs[o1] - bs[o2];
                    }
                    return o1 - o2;
                }
            });

            for (int i = 0; i < list.size(); i++) {
                arr[i] = list.get(i);
            }

            return arr;
        }

        public int[] sortByBits2(int[] arr) {

            int[] bs = new int[10001];
            for (int i = 0; i < bs.length; i++) {
                bs[i] = bs[i >> 1] + (i & 1);
            }

            int[] bits = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                bits[i] = bs[arr[i]];
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
                    if (arr[i] > arr[j]) {
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

    }
}