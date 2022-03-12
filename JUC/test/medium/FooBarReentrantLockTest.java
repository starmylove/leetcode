package medium;

public class FooBarReentrantLockTest {
    public static void main(String[] args) {
        FooBarReentrantLock fooBar = new FooBarReentrantLock(5);
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
