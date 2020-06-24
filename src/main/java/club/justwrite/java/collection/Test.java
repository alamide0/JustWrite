package club.justwrite.java.collection;

/**
 * @author ACC
 * @desc 一次测试任务的抽象
 * @create 2020/6/15
 **/
public abstract class Test<C> {
    String name;

    Test(String name) {
        this.name = name;
    }

    abstract int test(C container, TestParams params);
}
