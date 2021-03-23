package club.justwrite.java.algorithm.leetcode.ptempfollow;

import club.justwrite.java.io.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/11/27
 **/
public class LeetCode0039 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    private static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {

            List<List<Integer>> ans = new ArrayList<>();
            dfs(ans, new ArrayList<>(), candidates, 0, target);

            return ans;
        }

        private void dfs(List<List<Integer>> ans, List<Integer> combine, int[] candidates, int index, int target) {
            if (index == candidates.length) return;

            if (target == 0) {
                ans.add(new ArrayList<>(combine));
                return;
            }

            dfs(ans, combine, candidates, index + 1, target);

            if (target - candidates[index] >= 0) {
                combine.add(candidates[index]);
                dfs(ans, combine, candidates, index, target - candidates[index]);
                combine.remove(combine.size() - 1);
            }
        }

    }
}
