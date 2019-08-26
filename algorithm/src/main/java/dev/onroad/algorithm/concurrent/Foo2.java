package dev.onroad.algorithm.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个不同的线程将会共用一个 Foo 实例。
 * <p>
 * 线程 A 将会调用 one() 方法
 * 线程 B 将会调用 two() 方法
 * 线程 C 将会调用 three() 方法
 * 请设计修改程序，以确保 two() 方法在 one() 方法之后被执行，three() 方法在 two() 方法之后被执行。
 * <p>
 * 输入: [1,2,3]
 * 输出: "onetwothree"
 * 解释:
 * 有三个线程会被异步启动。
 * 输入 [1,2,3] 表示线程 A 将会调用 one() 方法，线程 B 将会调用 two() 方法，线程 C 将会调用 three() 方法。
 * 正确的输出是 "onetwothree"。
 * <p>
 * 使用object对象锁解决
 */
class Foo2 {
    private ReentrantLock lock;
    private Condition secondCondition;
    private Condition thirdCondition;
    private volatile int state;

    public Foo2() {
        lock = new ReentrantLock();
        state = 1;
        secondCondition = lock.newCondition();
        thirdCondition = lock.newCondition();
    }


    public void one() {
        System.out.println("one");
    }

    public void two() {
        System.out.println("two");
    }

    public void three() {
        System.out.println("three");
    }

    public void first(Runnable printFirst) throws InterruptedException {
        try {
            lock.lock();
            state = 2;
            printFirst.run();
            secondCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            lock.lock();
            if (state != 2) {
                secondCondition.await();
            }
            state = 3;
            printSecond.run();
            thirdCondition.signal();
        } finally {
            lock.unlock();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            lock.lock();
            if (state != 3) {
                thirdCondition.await();
            }
            printThird.run();
        } finally {
            lock.unlock();
        }
    }

    /**
     * test
     */
    public static void main(String[] args) throws InterruptedException {


        Foo2 foo = new Foo2();
        Thread t1 = new Thread(() -> {
            try {
                foo.first(foo::one);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                foo.second(foo::two);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t3 = new Thread(() -> {
            try {
                foo.third(foo::three);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();
        t1.start();
        t2.start();

    }
}