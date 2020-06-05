package club.justwrite.java.algorithm;

import club.justwrite.java.io.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/6/1 10:14 AM
 **/
public class LeetCode1431 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3));
        Printer.print(solution.kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1));
        Printer.print(solution.kidsWithCandies(new int[]{12, 1, 12}, 10));
    }

    static class Solution {
        public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

            List<Boolean> result = new ArrayList<>(candies.length);
            int max = -1;

            for (int candy : candies) {
                if (candy > max) {
                    max = candy;
                }
            }

            for (int candy : candies) {
                result.add(candy + extraCandies >= max);
            }

            return result;
        }
    }
}
