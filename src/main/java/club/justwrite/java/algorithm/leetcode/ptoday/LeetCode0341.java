package club.justwrite.java.algorithm.leetcode.ptoday;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LeetCode0341 {

    public class NestedIterator implements Iterator<Integer> {

        private List<Integer> integerList = new ArrayList<>();
        private Iterator<Integer> integerIterator;

        public NestedIterator(List<NestedInteger> nestedList) {
            dfs(nestedList);
            integerIterator = integerList.iterator();
        }

        @Override
        public Integer next() {
            return integerIterator.next();
        }

        @Override
        public boolean hasNext() {
            return integerIterator.hasNext();
        }

        private void dfs(List<NestedInteger> nestedList){
            for(NestedInteger nestedInteger: nestedList){
                if(nestedInteger.isInteger()){
                    integerList.add(nestedInteger.getInteger());
                }else{
                    dfs(nestedInteger.getList());
                }
            }
        }

    }


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
    }

}
