package club.justwrite.java.base.collection;

import club.justwrite.java.base.io.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/6/17
 **/
public class ListPerformance {


    private static final int LOOPS = 500;
    private static final boolean isArrayList = false;

    private static int[] params = !isArrayList ? new int[]{10, LOOPS, 100, LOOPS, 1000, LOOPS, 10000, LOOPS} : new int[]{10, LOOPS, 100, LOOPS, 1000, LOOPS, 10000, LOOPS, 100000, LOOPS, 1000000, LOOPS};

    public static void main(String[] args) {
        ListPerformance performance = new ListPerformance();
        for (int i = 0; i < params.length; i += 2) {
            performance.testForeach(isArrayList, params[i], params[i + 1]);

            performance.testFori(isArrayList, params[i], params[i + 1]);

            Printer.printDivider();
        }
    }

    private int testForeach(boolean isArrayList, int... params) {

        return test("ForEach", new Run() {
            @Override
            public int test(List<Integer> list) {
                int sum = 0;
                for (int n : list) {
                    sum += n;
                }
                return sum;
            }
        }, isArrayList, params);

    }


    private int testFori(boolean isArrayList, int... params) {
        return test("ForI", new Run() {
            @Override
            public int test(List<Integer> list) {
                int sum = 0;
                for (int i = 0; i < list.size(); i++) {
                    sum += list.get(i);
                }
                return sum;
            }
        }, isArrayList, params);
    }

    private int test(String taskName, Run run, boolean isArrayList, int... params) {
        List<Integer> list = isArrayList ? arrayList(params[0]) : linkedList(params[0]);
        long start = System.nanoTime();

        int times = 0;
        for (int j = 0; j < params[1]; j++) {
            times += run.test(list);
        }
        Printer.print(taskName + " " + params[0] + " : cost " + ((System.nanoTime() - start) / params[1]));

        return times;
    }

    public List<Integer> arrayList(int size) {
        List<Integer> res = new ArrayList<>(size);
        fillList(res, size);
        return res;
    }

    public List<Integer> linkedList(int size) {
        List<Integer> res = new LinkedList<>();
        fillList(res, size);
        return res;
    }

    private void fillList(List<Integer> list, int size) {
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
    }

    interface Run {
        int test(List<Integer> list);
    }

}

