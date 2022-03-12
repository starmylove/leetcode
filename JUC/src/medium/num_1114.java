package medium;

public class num_1114 {
    private volatile int seq = 1 ;
    public num_1114() {
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while(seq != 1){
        }
        printFirst.run();
        seq ++ ;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(seq != 2){
        }
        printSecond.run();
        seq ++ ;
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while(seq != 3){
        }
        printThird.run();
        seq ++ ;
    }
}
