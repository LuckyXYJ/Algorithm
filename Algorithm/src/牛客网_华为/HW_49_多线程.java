package 牛客网_华为;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HW_49_多线程 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            CountDownLatch countDownLatch = new CountDownLatch(4);
            AlternativePrint alternativePrint = new AlternativePrint();
            //创建四个线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < n; i++) {
                            alternativePrint.printA();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < n; i++) {
                            alternativePrint.printB();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < n; i++) {
                            alternativePrint.printC();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i < n; i++) {
                            alternativePrint.printD();
                        }
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }).start();
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}

class AlternativePrint {
    private Lock lock = new ReentrantLock();
    private Condition conditionA = lock.newCondition();
    private Condition conditionB = lock.newCondition();
    private Condition conditionC = lock.newCondition();
    private Condition conditionD = lock.newCondition();
    private int number = 1;

    void printA() {
        lock.lock();
        try {
            if (number != 1) {
                conditionA.await();
            }
            System.out.print("A");
            //"A"打印结束，标记置为2，并唤醒打印"B"的线程
            number = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printB() {
        lock.lock();
        try {
            if (number != 2) {
                conditionB.await();
            }
            System.out.print("B");
            //"B"打印结束，标记置为3，并唤醒打印"C"的线程
            number = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printC() {
        lock.lock();
        try {
            if (number != 3) {
                conditionC.await();
            }
            System.out.print("C");
            //"C"打印结束，标记置为4，并唤醒打印"D"的线程
            number = 4;
            conditionD.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void printD() {
        lock.lock();
        try {
            if (number != 4) {
                conditionD.await();
            }
            System.out.print("D");
            //"D"打印结束，标记置为1，并唤醒打印"A"的线程
            number = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

/*
可能这个好点吧

import java.util.Scanner;

public class Main {
    private final static int THREAD_NUM = 4;
    private static char[] chs = new char[1032*THREAD_NUM];
    public static void main(String[] args) {
        createThreads();
        Scanner sc  = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            System.out.println(new String(chs).substring(0, n*THREAD_NUM));
        }
        sc.close();
    }

    //创建线程并进行调用
    private static void createThreads(){
        char ch = 'A';
        for(int i = 0; i < THREAD_NUM; i++){
            new Thread(new InnerThread(ch++, i)).start();
        }
    }

    //内部线程类
    private static class InnerThread implements Runnable{
        private char ch;
        private int index;
        public InnerThread(char ch, int index){
            this.ch = ch;
            this.index = index;
        }

        public void run() {
            while(this.index < chs.length){
                chs[this.index] = this.ch;
                this.index += THREAD_NUM;
            }
        }
    }

}

* */
