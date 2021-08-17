package club.justwrite.java.base.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ACC
 * @desc 测试的参数，size 是每次测试的 Collection 容量，loops 是需要重复执行的次数。
 * 因为一次测试的数据带有一定的随机性，所以需要 loop 多次，然后取平均数
 * @create 2020/6/15
 **/
public class TestParams {
    int size;
    int loops;

    TestParams(int size, int loops) {
        this.size = size;
        this.loops = loops;
    }

    public static List<TestParams> list(int... params) {
        if ((params.length & 1) == 1) throw new IllegalArgumentException("params 长度不能为奇数");
        int size = params.length / 2;

        List<TestParams> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            TestParams testParams = new TestParams(params[i], params[i + 1]);
            list.add(testParams);
        }

        return list;
    }
}
