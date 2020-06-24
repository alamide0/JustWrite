package club.justwrite.java.algorithm.leetcode.p1101_p1150;

import club.justwrite.java.io.Printer;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author ACC
 * @desc
 * @create 2020/6/1 2:26 PM
 **/
public class LeetCode1114 {

    public static void main(String[] args) {
        if (execute(new int[]{3, 1, 2}, "firstsecondthird")) {
            Printer.print("3,1,2 测试通过");
        }

        if (execute(new int[]{2, 1, 3}, "firstsecondthird")) {
            Printer.print("2,1,3 测试通过");
        }

        if (execute(new int[]{2, 3, 1}, "firstsecondthird")) {
            Printer.print("2,3,1 测试通过");
        }

    }

    private static boolean execute(int[] order, String expectedResult) {
        StringWriter stringWriter = new StringWriter();

        Map<Integer, Runnable> tasks = new HashMap<>(3);
        tasks.put(1, new PrinterRunnable(stringWriter, "first"));
        tasks.put(2, new PrinterRunnable(stringWriter, "second"));
        tasks.put(3, new PrinterRunnable(stringWriter, "third"));

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Foo foo = new Foo(countDownLatch);

        for (int n : order) {
            executorService.execute(() -> {
                switch (n) {
                    case 1:
                        try {
                            foo.first(tasks.get(n));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            foo.second(tasks.get(n));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            foo.third(tasks.get(n));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        break;
                }
            });
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdownNow();
        }

        boolean result = Objects.equals(stringWriter.toString(), expectedResult);
        stringWriter.flush();
        try {
            stringWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    static class PrinterRunnable implements Runnable {

        private StringWriter stringWriter;
        private String printMess;

        public PrinterRunnable(StringWriter stringWriter, String printMess) {
            this.stringWriter = stringWriter;
            this.printMess = printMess;
        }

        @Override
        public void run() {
            stringWriter.write(printMess);
        }
    }

    static class Foo {

        private CountDownLatch countDownLatch;
        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);

        public Foo(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        public Foo() {

        }

        public void first(Runnable printFirst) throws InterruptedException {

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            semaphore1.release();
        }

        public void second(Runnable printSecond) throws InterruptedException {

            semaphore1.acquire();
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            semaphore2.release();
        }

        public void third(Runnable printThird) throws InterruptedException {

            // printThird.run() outputs "third". Do not change or remove this line.
            semaphore2.acquire();
            printThird.run();
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}