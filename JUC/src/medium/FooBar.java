package medium;

public class FooBar {

    private int n;
    private volatile boolean fooExec = true ;
    Object lock = new Object();

    public FooBar(int n) {
        this.n = n ;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized (lock){
                if(!fooExec){
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooExec = false ;
                lock.notifyAll();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            synchronized(lock){
                if(fooExec){
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                fooExec = true ;
                lock.notifyAll();
            }
        }
    }
    public static void main(String[] args){
        FooBarYield fooBar = new FooBarYield(5);
        Runnable target;
        Thread foo = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("foo");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread bar = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fooBar.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("bar");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        foo.start();
        bar.start();
    }
}