package club.justwrite.java.base.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/6/15
 **/
public abstract class Tester<C> {

    public static int[] defaultP = {10, 5000, 100, 5000, 1000, 5000, 10000, 5000, 100000, 5000};
    public static List<TestParams> paramsList = TestParams.list(defaultP);

    String taskName;

    abstract C initlize();

    List<Test<C>> tests = new ArrayList<>();

    void timeTest() {

        for (TestParams testParams : paramsList) {
            for (Test<C> t : tests) {
                C c = initlize();

                long start = System.nanoTime();
                t.test(c, testParams);

                long cost = System.nanoTime() - start;

                System.out.print("task " + t.name + ", cost " + cost + "    ");
            }

            System.out.println();
        }

    }

}
