package club.justwrite.java.algorithm.leetcode.p0351_p0400;

import club.justwrite.java.base.io.Printer;

import java.util.*;

/**
 * @author ACC
 * @desc
 * @create 2020/10/31
 **/
public class LeetCode0381 {

    public static void main(String[] args) {
        RandomizedCollection randomizedCollection = new RandomizedCollection();

        Printer.print(randomizedCollection.insert(4));
        Printer.print(randomizedCollection.insert(3));
        Printer.print(randomizedCollection.insert(4));
        Printer.print(randomizedCollection.insert(2));
        Printer.print(randomizedCollection.insert(4));


        Printer.print(randomizedCollection.remove(4));
        Printer.print(randomizedCollection.remove(3));
        Printer.print(randomizedCollection.remove(4));
        Printer.print(randomizedCollection.remove(4));


    }

    private static class RandomizedCollection {


        private class Node {
            int val;
            Node next;

            Node(int val) {
                this.val = val;
            }
        }

        private HashMap<Integer, Node> hashMap = new HashMap<>();
        private int[] values = new int[8];
        private int pointer = 0;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {

        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            checkSize();
            boolean res = hashMap.containsKey(val);
            if (res) {
                Node node = hashMap.get(val);

                while (node.next != null) {
                    node = node.next;
                }
                node.next = new Node(pointer);
            } else {
                hashMap.put(val, new Node(pointer));
            }

            values[pointer++] = val;
            return !res;
        }

        private void checkSize() {
            if (pointer == values.length) {
                int[] newValues = new int[values.length * 2];
                System.arraycopy(values, 0, newValues, 0, values.length);
                values = newValues;
            }
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            boolean res = hashMap.containsKey(val);

            if (res) {
                int index = hashMap.get(val).val;

                if (index != (pointer - 1)) {

                    int lastVal = values[pointer - 1];
                    Node lastValIndexNode = hashMap.get(lastVal);
                    values[index] = lastVal;

                    while (lastValIndexNode != null) {
                        if (lastValIndexNode.val == pointer - 1) {
                            lastValIndexNode.val = index;
                            break;
                        }
                        lastValIndexNode = lastValIndexNode.next;
                    }
                }

                pointer--;

                Node next = hashMap.get(val).next;
                if (next == null) {
                    hashMap.remove(val);
                } else {
                    hashMap.put(val, next);
                }
            }


            return res;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            Random random = new Random();
            return values[random.nextInt(pointer)];
        }
    }
}

