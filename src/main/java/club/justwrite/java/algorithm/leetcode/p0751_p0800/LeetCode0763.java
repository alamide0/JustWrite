package club.justwrite.java.algorithm.leetcode.p0751_p0800;

import club.justwrite.java.base.io.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/10/22
 **/
public class LeetCode0763 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Printer.print(solution.partitionLabels("ababcbacadefegdehijhkasdsadassdsafasdfdssafjlaskshfkasidhfgaksiudhfkasjhfkuashflakshjflakshjfbcnksajhfcjksdalij"));
    }

    static class Solution {
        public List<Integer> partitionLabels(String S) {
            int[] lastIndex = new int[26];

            for (int i = 0; i < S.length(); i++) {
                lastIndex[S.charAt(i) - 'a'] = i;
            }

            List<Integer> res = new ArrayList<>();
            int start = 0, end = 0;

            for (int i = 0; i < S.length(); i++) {
                end = Math.max(lastIndex[S.charAt(i) - 'a'], end);
                if (i == end) {
                    res.add(end - start + 1);
                    start = end + 1;
                }
            }

            return res;
        }
    }
}