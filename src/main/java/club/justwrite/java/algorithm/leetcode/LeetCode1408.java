package club.justwrite.java.algorithm.leetcode;

import club.justwrite.java.io.Printer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/6/20
 **/
public class LeetCode1408 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
        Printer.print(solution.stringMatching(new String[]{"leetcode","et","code"}));
        Printer.print(solution.stringMatching(new String[]{"blue","green","bu"}));
    }

    static class Solution {
        public List<String> stringMatching(String[] words) {

            List<String> res = new ArrayList<>();
            Arrays.sort(words, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });


            for (int i = 0; i < words.length; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[j].contains(words[i])) {
                        res.add(words[i]);
                        break;
                    }
                }
            }

            return res;
        }
    }
}

