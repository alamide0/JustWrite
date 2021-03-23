package club.justwrite.java.algorithm.leetcode.ptoday;

import club.justwrite.java.io.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/12/9
 **/
public class LeetCode0842 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Printer.print(Integer.parseInt("14748364721"));
        Printer.print(solution.splitIntoFibonacci("74912134825162255812723932620170946950766784234934"));

    }

    private static class Solution {
        public List<Integer> splitIntoFibonacci(String S) {

            int maxLength = String.valueOf(Integer.MAX_VALUE).length();
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i <= S.length() / 3 && i < maxLength; i++) {
                for (int j = i + 1; j <= i + (S.length() - i - 1) / 2 && j < i + 1 + maxLength; j++) {
                    long startNum = Long.parseLong(S.substring(0, i + 1));
                    long secondNum = Long.parseLong(S.substring(i + 1, j + 1));
                    if (startNum > Integer.MAX_VALUE || secondNum > Integer.MAX_VALUE) continue;

                    ans.add((int) startNum);
                    ans.add((int) secondNum);

                    StringBuilder nextString = new StringBuilder();
                    nextString.append(startNum).append(secondNum);

                    while (S.length() > nextString.toString().length() && S.startsWith(nextString.toString())) {
                        long tmp = secondNum;
                        secondNum = startNum + secondNum;
                        startNum = tmp;

                        if (secondNum > Integer.MAX_VALUE) break;

                        nextString.append(secondNum);
                        ans.add((int) secondNum);
                    }

                    if (ans.size() > 2 && S.length() == nextString.toString().length() && S.equals(nextString.toString())) {
                        return ans;
                    } else {
                        ans.clear();
                    }

                }
            }

            return ans;
        }
    }
}
