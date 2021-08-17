package club.justwrite.java.algorithm.leetcode.ptempfollow;

import club.justwrite.java.base.io.Printer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ACC
 * @desc
 * @create 2020/11/30
 **/
public class LeetCode0767 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.reorganizeString("aaaaabbbbbcccc"));
    }


    private static class Solution {
        public String reorganizeString(String S) {

            if (S.length() < 2) return S;
            int[] chars = new int[26];

            int maxCount = 0;
            for (int i = 0; i < S.length(); i++) {
                chars[S.charAt(i) - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                maxCount = Math.max(maxCount, chars[i]);
            }

            if (maxCount > (S.length() + 1) / 2) {
                return "";
            }


            StringBuilder stringBuilder = new StringBuilder();

            PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return chars[o2 - 'a'] - chars[o1 - 'a'];
                }
            });

            for (int i = 0; i < 26; i++) {
                if (chars[i] > 0) {
                    priorityQueue.offer((char) ('a' + i));
                }
            }


            while (priorityQueue.size() > 1) {
                char c1 = priorityQueue.poll();
                char c2 = priorityQueue.poll();
                chars[c1 - 'a']--;
                chars[c2 - 'a']--;

                stringBuilder.append(c1).append(c2);

                if (chars[c1 - 'a'] > 0) {
                    priorityQueue.offer(c1);
                }

                if (chars[c2 - 'a'] > 0) {
                    priorityQueue.offer(c2);
                }
            }

            if (priorityQueue.size() == 1) {
                stringBuilder.append(priorityQueue.poll());
            }


            return stringBuilder.toString();


        }
    }
}
