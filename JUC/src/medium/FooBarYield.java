package medium;

public class FooBarYield {
    private int n;
    volatile boolean fooExec = true ;
    public FooBarYield(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; ) {
            if(fooExec){
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooExec = false ;
                i ++ ;
            }else {
                Thread.yield();
            }
        }
    }
    public void bar(Runnable printBar) throws InterruptedException{
        for (int i = 0; i < n;) {
            if(!fooExec){
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooExec = true ;
                i ++ ;
            }else {
                Thread.yield();
            }
        }
    }
}