package medium;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class FooBarCyclicBarrier {
    private final int n;
    CyclicBarrier cb = new CyclicBarrier(2);
    volatile boolean fooExec = true ;
    public FooBarCyclicBarrier(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while (!fooExec){

            }
            printFoo.run();
            fooExec = false ;
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
    public void bar(Runnable printBar) throws InterruptedException{
        for (int i = 0; i < n; i++) {
            try {
                cb.await();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            printBar.run();
            fooExec = true ;
        }

    }
}
