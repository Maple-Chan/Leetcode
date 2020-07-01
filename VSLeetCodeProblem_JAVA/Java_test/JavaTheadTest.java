package Java_test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-06-30 20:24:46
 * @version: 0.0.1
 */
public class JavaTheadTest {
    public static final int COUNT = 100;

    public static void main(String[] args) {
        // 1.
        new Thread(new MyThread(), "线程1,实现Runnable接口").start();
        // 2.
        new Thread(new Runnable() {
            @Override
            public void run() {
                int count = COUNT;
                while (count > 0) {
                    System.out.println("1. In Runnable");
                    count--;
                }
            }
        }, "线程1,实现Runnable接口,在调用处定义线程内容").start();

        // 3.
        new MyThread2().start();

        // 4.
        MyCallable myCallable = new MyCallable();
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        String res = null;

        try {
            new Thread(futureTask, "线程Callable").start();
            res = futureTask.get();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(res);

    }

}

class MyThread implements Runnable {

    /**
      *@description 
      *@author Maple Chan
      *@date: 2020-06-30 20:22:59
      *@params void
      *@return void
     */
    @Override
    public void run() {
        int count = JavaTheadTest.COUNT;
        while (count > 0) {
            System.out.println("2. In MyThread");
            count--;
        }
    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        super.run();

        int count = JavaTheadTest.COUNT;
        while (count > 0) {
            System.out.println("3. In MyThread2");
            count--;
        }

    }
}

class MyCallable implements Callable<String> {
    /**
     * 该call方法作为线程执行体，并且有返回值
     */
    @Override
    public String call() throws Exception {

        int count = JavaTheadTest.COUNT;
        while (count > 0) {
            System.out.println("4. In MyCallable");
            count--;
        }


        return "success";
    }

}
