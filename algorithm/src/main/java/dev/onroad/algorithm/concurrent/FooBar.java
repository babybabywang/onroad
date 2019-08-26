package dev.onroad.algorithm.concurrent;

import java.util.concurrent.Semaphore;

/**
 * @author echo huang
 * @version 1.0
 * @date 2019-08-07 22:33
 * @description 两个不同的线程将会共用一个 FooBar 实例。其中一个线程将会调用 foo() 方法，另一个线程将会调用 bar() 方法。
 * <p>
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2:
 * <p>
 * 输入: n = 2
 * 输出: "foobarfoobar"
 * 解释: "foobar" 将被输出两次。
 */
public class FooBar {
    private int n;
    private Semaphore semaphoreFoo;
    private Semaphore semaphoreBar;

    public FooBar(int n) {
        this.n = n;
        semaphoreFoo = new Semaphore(0);
        semaphoreBar = new Semaphore(0);
    }

    public  void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphoreBar.release();
            semaphoreFoo.acquire();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            semaphoreBar.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphoreFoo.release();

        }
    }

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(6);
        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.start();
        t1.start();
    }
}
