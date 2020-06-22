package club.justwrite.java.algorithm.leetcode.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc
 * @create 2020/6/22
 **/
public class Tester<Result> {
    private List<TestParams<Result>> testList = new ArrayList<>();

    private Tester(List<TestParams<Result>> testList) {
        this.testList = testList;
    }

    public void test(Object obj) {
        Method destMethod = null;
        for (Method method : obj.getClass().getDeclaredMethods()) {
            if (method.getAnnotation(MainMethod.class) != null) {
                destMethod = method;
                break;
            }
        }

        if (destMethod == null) {
            throw new RuntimeException("Class " + obj.getClass().getSimpleName() + " not find mainMethod " );
        }

        destMethod.setAccessible(true);

        for (TestParams testParams : testList) {
            try {
                testParams.isCorrect(destMethod.invoke(obj, testParams.params));
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    public static <Result> void test(Object[] testParams, Object dest) {

        if ((testParams.length & 1) != 0) {
            throw new IllegalArgumentException("testParams.length must be not odd");
        }

        List<TestParams<Result>> list = new ArrayList<>(testParams.length);

        for (int i = 0; i < testParams.length; i += 2) {
            TestParams params;
            if (testParams[i].getClass().isArray()) {
                params = new TestParams((Object[]) testParams[i], testParams[i + 1]);
            } else {
                params = new TestParams(testParams[i], testParams[i + 1]);
            }
            list.add(params);
        }
        new Tester<>(list).test(dest);
    }
}
