package club.justwrite.java.algorithm.leetcode.p0351_p0400;

/**
 * @author ACC
 * @desc
 * @create 2020/11/24
 **/
public class LeetCode0374 {


    private static class GuessGame {
        int guess(int n) {
            return 0;
        }

    }

    public static class Solution extends GuessGame {
        public int guessNumber(int n) {
            int left = 1, right = n;
            while (left < right) {
                int middle = (right - left + 1) / 2 + left;
                if (guess(middle) < 0) {
                    right = middle - 1;

                } else {
                    left = middle;
                }
            }

            return left;
        }
    }
}