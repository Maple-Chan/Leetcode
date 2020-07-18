package javatest;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-06-30 20:25:30
 * @version: 0.0.1
 */
public class WaitNotifyTest {

    private static Object lockObject = new Object();

    public static void main(String[] args) {
        waitThread();
        notifyThread();

    }

    private static void waitThread() {
        Thread waitThread = new Thread(new Runnable() {

            @Override
            public void run() {

                synchronized (lockObject) {
                    System.out.println(Thread.currentThread().getName() + " before wait");

                    try {
                        TimeUnit.SECONDS.sleep(2);
                        lockObject.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                System.out.println(Thread.currentThread().getName() + " after wait");
            }
        }, "waitThread");

        waitThread.start();
    }

    private static void notifyThread() {
        Thread notifyThread = new Thread(new Runnable() {

            @Override
            public void run() {

                System.out.println(Thread.currentThread().getName() + " before notify");

                synchronized (lockObject) {
                    // notify也必须在synchronized当中
                    lockObject.notify();
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                System.out.println(Thread.currentThread().getName() + " after notify");
            }
        }, "notifyThread");

        notifyThread.start();

    }

}