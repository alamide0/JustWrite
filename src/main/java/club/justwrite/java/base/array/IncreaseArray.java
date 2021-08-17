package club.justwrite.java.base.array;

import club.justwrite.java.base.io.Printer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc 测试数组 与 容器扩展的性能
 * @create 2020/5/21 10:12 AM
 * =============================================================================================
 * ArrayFloatContainer: size = 10 cost time 0ms
 * CollectionFloatContainer: size = 10 cost time 1ms
 * =============================================================================================
 * ArrayFloatContainer: size = 100 cost time 0ms
 * CollectionFloatContainer: size = 100 cost time 0ms
 * =============================================================================================
 * ArrayFloatContainer: size = 1000 cost time 0ms
 * CollectionFloatContainer: size = 1000 cost time 2ms
 * =============================================================================================
 * ArrayFloatContainer: size = 10000 cost time 0ms
 * CollectionFloatContainer: size = 10000 cost time 3ms
 * =============================================================================================
 * ArrayFloatContainer: size = 100000 cost time 5ms
 * CollectionFloatContainer: size = 100000 cost time 7ms
 * =============================================================================================
 * ArrayFloatContainer: size = 1000000 cost time 12ms
 * CollectionFloatContainer: size = 1000000 cost time 29ms
 * =============================================================================================
 * ArrayFloatContainer: size = 10000000 cost time 61ms
 * CollectionFloatContainer: size = 10000000 cost time 2439ms
 * =============================================================================================
 * ArrayFloatContainer: size = 100000000 cost time 835ms
 * CollectionFloatContainer: size = 100000000 cost time 31655ms
 * =============================================================================================
 **/
public class IncreaseArray {

    public static void main(String[] args) {
        int[] times = new int[7];
        for (int i = 0; i < times.length; i++) {
            times[i] = (int) Math.pow(10, i + 1);
        }
        Printer.print("=============================================================================================");
        for (int i = 0; i < times.length; i++) {
            test(times[i]);
            test2(times[i]);
            Printer.print("=============================================================================================");
        }
    }

    public static void test(int size) {
        testIncrease(new ArrayFloatContainer(0.85f), size);
    }

    public static void test2(int size) {
        testIncrease(new CollectionFloatContainer(0.85f), size);
    }

    public static void testIncrease(IGetFloat iGetFloat, int size) {
        long startMills = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            iGetFloat.getN(i);
        }
        Printer.print(iGetFloat.getClass().getSimpleName() + ": size = " + size + " cost time " + (System.currentTimeMillis() - startMills) + "ms");
    }


    interface IGetFloat {
        float getN(int n);
    }

    public static class ArrayFloatContainer implements IGetFloat {

        private static final int INIT_SIZE = 5;

        private float[] cachedResult = new float[INIT_SIZE];

        private final float multiFactor;

        public ArrayFloatContainer(float multiFactor) {
            this.multiFactor = multiFactor;
        }

        @Override
        public float getN(int n) {
            if (n >= cachedResult.length) {
                float[] newF = new float[cachedResult.length * 2];
                System.arraycopy(cachedResult, 0, newF, 0, cachedResult.length);
                cachedResult = newF;
                return getN(n);
            } else {
                if (cachedResult[n] == 0.0f) {
                    cachedResult[n] = multiFactor * n;
                }
                return cachedResult[n];
            }
        }
    }

    public static class CollectionFloatContainer implements IGetFloat {

        private static final int INIT_SIZE = 5;
        private List<Float> cache = new ArrayList<>(INIT_SIZE);
        private final float multiFactor;

        public CollectionFloatContainer(float multiFactor) {
            this.multiFactor = multiFactor;
        }

        @Override
        public float getN(int n) {
            if (n >= cache.size()) {
                cache.add(n, multiFactor * n);
            } else {
                if (cache.get(n) == 0.0f) {
                    cache.set(n, multiFactor * n);
                }
            }

            return cache.get(n);
        }
    }
}
