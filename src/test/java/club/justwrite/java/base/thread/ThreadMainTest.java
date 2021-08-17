package club.justwrite.java.base.thread;

import org.junit.Test;

import java.time.LocalTime;

public class ThreadMainTest {
    @Test
    public void testJoin() throws InterruptedException {
        Thread thread = new Thread(() -> {
            System.out.println("hello!");
        });

        System.out.println("start");
        thread.start();
        thread.join();
        System.out.println("end");
    }

    @Test
    public void testInterrupted() throws InterruptedException {
        class MyThread extends Thread {
            int n = 0;

            @Override
            public void run() {
                while (!isInterrupted()) {
                    n++;
                    System.out.println(n + "......");
                }
            }
        }

        MyThread t = new MyThread();
        t.start();
        Thread.sleep(1);
        t.interrupt();
        t.join();
        t.interrupt();
        System.out.println("end......");
    }

    @Test
    public void testDaemon(){

    }

//    @Test
    public void testInterrupted2() throws InterruptedException {
        class MyThread extends Thread {
            @Override
            public void run() {
                Thread hello = new HelloThread();
                hello.start();
                try {
                    hello.join();
                } catch (InterruptedException e) {
                    System.out.println("interrupted!");
                }
                hello.interrupt();
            }
        }

        Thread t = new MyThread();
        t.start();
        System.out.println("begin sleep");
        Thread.sleep(1000);
        System.out.println("end sleep");
        t.interrupt();
        t.join();
        System.out.println("end");
    }

    static class HelloThread extends Thread {
        @Override
        public void run() {
            int n = 0;
            while (!isInterrupted()) {
                n++;
                System.out.println(n + " hello!");

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        }
    }
}