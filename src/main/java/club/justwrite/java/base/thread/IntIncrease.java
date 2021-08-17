package club.justwrite.java.base.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class IntIncrease {
    private AtomicInteger num = new AtomicInteger(0);

    public void increase() {
        num.addAndGet(1);
    }

    public int getNum() {
        return num.get();
    }
}
