package club.justwrite.java.algorithm.leetcode.ptempfollow;

/**
 * @author ACC
 * @desc  学习题解 KMP 算法， 及一行代码的证明
 * @create 2020/11/10
 **/
public class LeetCode0459 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public boolean repeatedSubstringPattern(String s) {

            return (s + s).indexOf(s, 1) != s.length();

        }
    }
}
