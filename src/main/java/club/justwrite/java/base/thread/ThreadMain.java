package club.justwrite.java.base.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadMain {

    public static void main(String[] args) throws InterruptedException {

        ChopStick[] chopSticks = new ChopStick[5];
        for (int i = 0; i < 5; i++) {
            chopSticks[i] = new ChopStick();
        }

        Philosopher[] philosophers = new Philosopher[5];

        for(int i=0; i < 5; i++){
            philosophers[i] = new Philosopher(chopSticks[i], chopSticks[(i+1)%5], i);
        }

        ExecutorService executorService = Executors.newCachedThreadPool();
        for(int i=0; i < 5; i++){
            executorService.execute(philosophers[i]);
        }

    }

    static class ChopStick {
        private boolean isToken;

        public synchronized void take() throws InterruptedException {
            while (isToken) {
                wait();
            }

            isToken = true;
        }

        public synchronized void drop() {
            isToken = false;
            notifyAll();
        }
    }

    static class Philosopher implements Runnable {

        private ChopStick left;
        private ChopStick right;
        private int id;

        public Philosopher(ChopStick left, ChopStick right, int id) {
            this.left = left;
            this.right = right;
            this.id = id;
        }

        private Random random = new Random();

        private void pause() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(0);
        }

        @Override
        public void run() {
            try {
                while (!Thread.interrupted()) {
                    System.out.println("Philosopher" + id + " is thinking...");
                    pause();

                    left.take();
                    System.out.println("Philosopher" + id + " take left chopstick...");
                    right.take();

                    System.out.println("Philosopher" + id + " take right chopstick...");
                    pause();

                    left.drop();
                    System.out.println("Philosopher" + id + " drop left chopstick...");
                    right.drop();
                    System.out.println("Philosopher" + id + " drop right chopstick...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
