package club.justwrite.java.algorithm.leetcode.ptoday;

import club.justwrite.java.io.Printer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author ACC
 * @desc
 * @create 2020/12/11
 **/
public class LeetCode0649 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        Printer.print(solution.predictPartyVictory("RDDRDRDRDRR"));
    }

    private static class Solution {
        public String predictPartyVictory(String senate) {
           Queue<Integer> rQ = new LinkedList<>();
           Queue<Integer> dQ = new LinkedList<>();

           int n = senate.length();
           for(int i=0; i < n; i++){
               if(senate.charAt(i) == 'R'){
                   rQ.offer(i);
               }else{
                   dQ.offer(i);
               }
           }

           int count=0;
           while (!rQ.isEmpty() && !dQ.isEmpty()){
               int i1 = rQ.poll(), i2=dQ.poll();

               if(i1 > i2){
                   dQ.offer(n+count);
               }else{
                   rQ.offer(n+count);
               }

               count++;
           }

           return rQ.isEmpty() ? "Dire" : "Radiant";
        }


    }
}
