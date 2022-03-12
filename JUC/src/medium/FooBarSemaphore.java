package medium;

import java.util.concurrent.Semaphore;

public class FooBarSemaphore {
    private int n;
    Semaphore fooSema = new Semaphore(1);
    Semaphore barSema = new Semaphore(0);

    public FooBarSemaphore(int n) {
        this.n = n;
    }
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSema.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barSema.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSema.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            fooSema.release();
        }
    }
}