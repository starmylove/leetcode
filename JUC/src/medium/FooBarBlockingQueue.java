package medium;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FooBarBlockingQueue {
    private int n ;
    BlockingQueue<Integer> fooQueue = new LinkedBlockingQueue<Integer>(){{
        add(0);
    }};
    BlockingQueue<Integer> barQueue = new LinkedBlockingQueue<>();
    public FooBarBlockingQueue(int n){
        this.n = n ;
    }
    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooQueue.take();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            barQueue.put(0);
        }
    }
    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barQueue.take();
            printBar.run();
            fooQueue.put(0);
        }
    }
}
