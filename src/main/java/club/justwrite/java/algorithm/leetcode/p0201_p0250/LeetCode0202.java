package club.justwrite.java.algorithm.leetcode.p0201_p0250;

import java.util.HashSet;

/**
 * @author ACC
 * @desc
 * @create 2020/11/17
 **/
public class LeetCode0202 {

    public static void main(String[] args) {

    }

    private static class Solution {

        HashSet<Integer> set = new HashSet<>();

        public boolean isHappy(int n) {

            if (set.contains(n)) return false;

            if (n == 1) return true;
            set.add(n);
            int sum = 0;

            while (n != 0) {
                sum += (n % 10) * (n % 10);
                n = n / 10;
            }

            return isHappy(sum);
        }
    }
}