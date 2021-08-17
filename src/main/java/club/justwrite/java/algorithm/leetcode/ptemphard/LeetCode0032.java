package club.justwrite.java.algorithm.leetcode.ptemphard;

/**
 * @author ACC
 * @desc
 * @create 2020/11/10
 **/
public class LeetCode0032 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Printer.print(solution.longestValidParentheses("()(()"));
    }

    private static class Solution {
//        public int longestValidParentheses(String s) {
//
//        }
//
//        private void reverse(char[] chars){
//            for(int i=0; i <= (chars.length-1)/2; i++){
//                char tmp = chars[i];
//
//                chars[i] = chars[chars.length-1-i];
//            }
//        }
//
//        private int count(char[] chars, char first, char second) {
//            Stack<Character> stack = new Stack<>();
//
//            int ans = 0;
//            int count = 0;
//            for (char c : chars) {
//                if (c == second) {
//                    if (!stack.isEmpty()) {
//                        char cc = stack.pop();
//                        if (cc == first) {
//                            count += 2;
//                        } else {
//                            ans = Math.max(ans, count);
//                            count = 0;
//                        }
//
//                    } else {
//                        ans = Math.max(ans, count);
//                        count = 0;
//                    }
//                } else {
//                    stack.push(c);
//                }
//            }
//
//            return Math.max(ans, count);
//        }
    }
}
