package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.io.Printer;

import java.util.*;

/**
 * @author ACC
 * @desc 最短路径 -------> 图的广度优先遍历
 * @create 2020/11/5
 **/
public class LeetCode0127 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        Printer.print(solution.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog", "cit", "cot")));
    }

    /**
     * 单纯的图的广度优先遍历
     */
    private static class Solution {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            if (!wordList.contains(endWord)) return 0;

            boolean[] tags = new boolean[wordList.size()];
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            int count = 0;
            while (!queue.isEmpty()) {

                int size = queue.size();

                count++;
                for (int i = 0; i < size; i++) {
                    String w = queue.poll();

                    if (w.equals(endWord)) {
                        return count;
                    }

                    for (int j = 0; j < wordList.size(); j++) {
                        if (tags[j]) continue;

                        if (isSatisfied(w, wordList.get(j))) {
                            queue.offer(wordList.get(j));
                            tags[j] = true;
                        }
                    }
                }


            }

            return 0;

        }

        private boolean isSatisfied(String w1, String w2) {
            char[] chars1 = w1.toCharArray();
            char[] chars2 = w2.toCharArray();

            int count = 0;
            for (int i = 0; i < chars1.length; i++) {
                if (chars1[i] != chars2[i]) count++;

                if (count > 1) {
                    return false;
                }
            }

            return count == 1;
        }

    }

    private static class Solution2 {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {



            return 0;
        }
    }
}