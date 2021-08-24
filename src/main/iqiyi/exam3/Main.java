package main.iqiyi.exam3;


import java.util.Scanner;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        final Scanner reader = new Scanner(System.in);
        int n = reader.nextInt();
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(n);
        new Thread(() -> {
            try {
                zeroEvenOdd.printZero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.printEven(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.printOdd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ZeroEvenOdd {
    private Integer n;
    private Boolean zero;
    private int now = 1;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zero = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void printZero(IntConsumer printNumber) throws InterruptedException {
        for (; ; ) {
            if (now > n) {
                return;
            }
            synchronized (zero) {
                if (zero) {
                    if (now > n) {
                        return;
                    }
                    printNumber.accept(0);
                    zero = false;
                    continue;
                }
            }
        }
    }

    public void printEven(IntConsumer printNumber) throws InterruptedException {
        //偶数
        for (; ; ) {
            if (now > n) {
                return;
            }
            synchronized (zero) {
                if (!zero) {
                    synchronized (n) {
                        if (now > n) {
                            return;
                        }
                        if (now % 2 == 0) {
                            printNumber.accept(now);
                            zero = true;
                            now++;
                            continue;
                        }
                    }
                }
            }
        }
    }

    public void printOdd(IntConsumer printNumber) throws InterruptedException {
        for (; ; ) {
            if (now > n) {
                return;
            }
            synchronized (zero) {
                if (!zero) {
                    synchronized (n) {
                        if (now > n) {
                            return;
                        }
                        if (now % 2 != 0) {
                            printNumber.accept(now);
                            zero = true;
                            now++;
                            continue;
                        }
                    }
                }
            }
        }
    }


}
