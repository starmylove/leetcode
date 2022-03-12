package easy;

public class num_1114_1 {
    public static  int count = 1 ;
    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        count ++ ;
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while (count != 2) {
            ;
        }
        printSecond.run();
        count++;
    }

    public void third(Runnable printThird) throws InterruptedException {

        // printThird.run() outputs "third". Do not change or remove this line.
        while (count!=3) {
            ;
        }
        printThird.run();

    }
    public static void main(String[] args) throws Exception {
        Thread thread= new Thread(() -> {
            while (count == 1) {
                ;
            }
            System.out.println("result");
        });
        thread.start();
        Thread.sleep(100);
        count++;
        System.out.println(count);
        thread.join();
    }
}