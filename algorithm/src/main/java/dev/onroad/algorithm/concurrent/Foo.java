package dev.onroad.algorithm.concurrent;

import java.util.concurrent.CountDownLatch;

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
 *
 * 使用俩个countLatch解决
 */
class Foo {

    private CountDownLatch countDownLatch1;
    private CountDownLatch countDownLatch2;

    public Foo() {
        countDownLatch1 = new CountDownLatch(1);
        countDownLatch2 = new CountDownLatch(1);

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
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        countDownLatch1.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        countDownLatch1.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        countDownLatch2.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        countDownLatch2.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

    /**
     * test
     */
    public static void main(String[] args) throws InterruptedException {


        Foo foo = new Foo();
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