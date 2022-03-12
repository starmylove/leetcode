package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.LockSupport;

public class FooBarLockSupport {
    private int n ;
    private boolean fooExec = true ;
    public FooBarLockSupport(int n){
        this.n = n ;
    }
    Map<String,Thread> map = new HashMap<>();
    public void foo(Runnable printFoo) throws InterruptedException {
        map.put("foo",Thread.currentThread());
        for (int i = 0; i < n; i++) {
            if(!fooExec){
                LockSupport.park();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            fooExec = false ;
            LockSupport.unpark(map.get("bar"));
        }
    }
    public void bar(Runnable printBar) throws InterruptedException {
        map.put("bar",Thread.currentThread());
        for (int i = 0; i < n; i++) {
            if(fooExec){
                LockSupport.park();
            }
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printBar.run();
            fooExec = true ;
            LockSupport.unpark(map.get("foo"));
        }
    }
}
