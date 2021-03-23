package club.justwrite.java.algorithm.leetcode.ptoday;

import club.justwrite.java.io.Printer;

/**
 * @author ACC
 * @desc
 * @create 2021/2/7
 **/
public class LeetCode0665 {

    public static void main(String[] args){
        Solution solution = new Solution();
        Printer.print(solution.checkPossibility(new int[]{3,4,2,3}));
        Printer.print(solution.checkPossibility(new int[]{5,7,1,8}));
    }


    private static class Solution {
        public boolean checkPossibility(int[] nums) {
            int count = 0;
            for(int i=0; i < nums.length -1; i++){
                if(nums[i] > nums[i+1]){
                    count++;
                    if(count > 1) {
                        return false;
                    }
                    if((i > 0 && nums[i+1] < nums[i-1])) {
                        nums[i+1]=nums[i];
                    }
                }
            }
            return true;
        }
    }
}
