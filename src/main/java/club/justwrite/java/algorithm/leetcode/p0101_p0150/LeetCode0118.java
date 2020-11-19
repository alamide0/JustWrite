package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/11/19
 **/
public class LeetCode0118 {

    public static void main(String[] args) {

    }

    private static class Solution {
        public List<List<Integer>> generate(int numRows) {

            List<List<Integer>> ans = new ArrayList<>(numRows);
            if (numRows >= 1) {
                ans.add(Collections.singletonList(1));
            }

            if (numRows >= 2) {
                ans.add(Arrays.asList(1, 1));
            }

            if (numRows > 2) {
                for (int i = 3; i <= numRows; i++) {
                    List<Integer> cur = new ArrayList<>();
                    List<Integer> last = ans.get(i - 2);
                    int tmp = 0;
                    for (Integer aLast : last) {
                        cur.add(tmp + aLast);
                        tmp = aLast;
                    }
                    cur.add(1);
                    ans.add(cur);
                }
            }


            return ans;
        }
    }
}