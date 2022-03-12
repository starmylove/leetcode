package medium;

import java.util.concurrent.locks.ReentrantLock;

public class FooBarReentrantLock {
    private int n;
    volatile boolean fooExec = true ;
    ReentrantLock lock = new ReentrantLock(true);
    public FooBarReentrantLock(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            try{
                lock.lock();
                if(fooExec){
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    fooExec = false ;
                    i ++ ;
                }
            }finally {
                lock.unlock();
                if(!fooExec){
                    Thread.yield();
                }
            }
        }
    }
    public void bar(Runnable printBar) throws InterruptedException{

        for (int i = 0; i < n; ) {
            lock.lock();
            try {
                if(!fooExec){
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    fooExec = true ;
                    i ++ ;
                }
            }finally {
                lock.unlock();
                if(fooExec){
                    Thread.yield();
                }
            }
        }
    }

}
