package javatest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description:
 * @modifyContent:
 * @author: Maple Chan
 * @date: 2020-07-14 20:22:37
 * @version: 0.0.1
 */
public class JavaQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedBlockingQueue<>(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        // queue.add(3); 
        // Exception in thread "main" java.lang.IllegalStateException: Queue full
        //      at java.util.AbstractQueue.add(AbstractQueue.java:98)
        //      at Java_test.JavaQueue.main(JavaQueue.java:22)

        boolean isSucceed = queue.offer(3);
        System.out.println(isSucceed);
        // false
        
        
        Queue<Integer> queue2 = new LinkedBlockingQueue<>(3);
        // Integer integer = queue2.remove();
        // Exception in thread "main" java.util.NoSuchElementException
        //      at java.util.AbstractQueue.remove(AbstractQueue.java:117)
        //      at Java_test.JavaQueue.main(JavaQueue.java:31)

        Integer integer = queue2.poll();

        System.out.println(integer);
        //null


        Queue<Integer> queue3 = new LinkedBlockingQueue<>(3);

        // Integer integer2 = queue3.element();
        // Exception in thread "main" java.util.NoSuchElementException
        //      at java.util.AbstractQueue.element(AbstractQueue.java:136)
        //      at Java_test.JavaQueue.main(JavaQueue.java:43)

        Integer integer2 = queue3.peek();
        System.out.println(integer2);
        // null

    }
    
}