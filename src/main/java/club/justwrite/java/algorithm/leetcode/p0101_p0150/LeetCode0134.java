package club.justwrite.java.algorithm.leetcode.p0101_p0150;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2020/11/18
 **/
public class LeetCode0134 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        Printer.print(solution.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
        Printer.print(solution.canCompleteCircuit(new int[]{3, 3, 4}, new int[]{3, 4, 4}));
    }

    private static class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {

            int tag = -1;

            for (int i = 0; i < gas.length; i++) {

                if (gas[i] >= cost[i]) {
                    int sumCost = 0;
                    int sumGas = 0;
                    boolean isRight = true;
                    tag = i;
                    for (int j = tag; j < gas.length; j++) {
                        sumGas += gas[j];
                        sumCost += cost[j];

                        if (sumGas < sumCost) {
                            isRight = false;
                            i = j;
                            break;
                        }
                    }

                    Printer.print("====" + sumCost + ", "+sumGas);
                    if (isRight) {
                        for (int j = 0; j < tag; j++) {
                            sumGas += gas[j];
                            sumCost += cost[j];
                            if (sumGas < sumCost) {
                                isRight = false;
                                break;
                            }
                        }
                    }

                    Printer.print("====" + sumCost + ", "+sumGas);

                    tag = isRight ? tag : -1;

                    if (isRight) {
                        break;
                    }
                }
            }

            return tag;
        }
    }
}