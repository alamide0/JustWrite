package club.justwrite.java.algorithm.leetcode.ptempfollow;

import club.justwrite.java.base.io.Printer;

/**
 * @author ACC
 * @desc 单词搜索
 * @create 2020/11/2
 **/
public class LeetCode0079 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] nums = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        Printer.print(solution.exist(nums, "ABCCED"));
        Printer.print(solution.exist(nums, "SEE"));
        Printer.print(solution.exist(nums, "ABCB"));
        Printer.print(solution.exist(nums, "CCC"));
    }

    private static class Solution {
        public boolean exist(char[][] board, String word) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        int[][] tags = new int[board.length][board[0].length];
                        tags[i][j] = 1;
                        boolean res = backtrace(tags, board, word, i, j, 1);
                        if (res) return true;

                    }
                }
            }
            return false;
        }

        private boolean backtrace(int[][] tags, char[][] board, String word, int x, int y, int index) {

            if (index == word.length()) {
                return true;
            }


            if (checkBound(x - 1, y, board) && board[x - 1][y] == word.charAt(index) && tags[x - 1][y] != 1) {
                tags[x - 1][y] = 1;
                boolean res = backtrace(tags, board, word, x - 1, y, index + 1);
                if (res) {
                    return true;
                }
                tags[x - 1][y] = 0;
            }

            if (checkBound(x, y + 1, board) && board[x][y + 1] == word.charAt(index) && tags[x][y + 1] != 1) {
                tags[x][y + 1] = 1;
                boolean res = backtrace(tags, board, word, x, y + 1, index + 1);
                if (res) return true;
                tags[x][y + 1] = 0;
            }

            if (checkBound(x + 1, y, board) && board[x + 1][y] == word.charAt(index) && tags[x + 1][y] != 1) {
                tags[x + 1][y] = 1;
                boolean res = backtrace(tags, board, word, x + 1, y, index + 1);
                if (res) return true;
                tags[x + 1][y] = 0;
            }

            if (checkBound(x, y - 1, board) && board[x][y - 1] == word.charAt(index) && tags[x][y - 1] != 1) {
                tags[x][y - 1] = 1;
                boolean res = backtrace(tags, board, word, x, y - 1, index + 1);
                if (res) return true;
                tags[x][y - 1] = 0;
            }

            return false;
        }

        private boolean checkBound(int x, int y, char[][] board) {
            return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
        }

    }
}
