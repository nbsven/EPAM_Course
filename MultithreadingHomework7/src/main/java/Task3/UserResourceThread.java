package Task3;

import checkers.igj.quals.I;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class UserResourceThread {
    public static void main(String[] args) throws InterruptedException {
        SharedResource res = new SharedResource();
        AtomicInteger checker = new AtomicInteger(-1);
        AtomicInteger init = new AtomicInteger(-1);

        IntegerSetterGetter t1 = new IntegerSetterGetter("1", res, checker, init);
        IntegerSetterGetter t2 = new IntegerSetterGetter("2", res, checker, init);
        IntegerSetterGetter t3 = new IntegerSetterGetter("3", res, checker, init);
        IntegerSetterGetter t4 = new IntegerSetterGetter("4", res, checker, init);
        IntegerSetterGetter t5 = new IntegerSetterGetter("5", res, checker, init);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        Thread.sleep(100);

        t1.stopThread();
        t2.stopThread();
        t3.stopThread();
        t4.stopThread();
        t5.stopThread();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("main");
    }
}

class IntegerSetterGetter extends Thread {
    private SharedResource resource;
    private boolean run;
    private volatile AtomicInteger checker;
    private volatile AtomicInteger init;

    private Random rand = new Random();

    public IntegerSetterGetter(String name, SharedResource resource, AtomicInteger checker, AtomicInteger init) {
        super(name);
        this.resource = resource;
        this.checker = checker;
        this.init = init;
        this.init.incrementAndGet();
        this.checker.incrementAndGet();
        run = true;
    }

    public void stopThread() {
        run = false;
    }

    public void run() {
        int action;

        try {
            while (run || (checker.get() == 0 && init.get() != 0)) {
                action = rand.nextInt(1000);
                if (action % 2 == 0 && checker.get() == 0) {
                    checker.decrementAndGet();
                    getIntegersFromResource();
                    if (run)
                        checker.incrementAndGet();
                } else {
                    setIntegersIntoResource();
                }
            }
            System.out.println("Поток " + getName() + " завершил работу.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void getIntegersFromResource() throws InterruptedException {
        Integer number;

        synchronized (resource) {
            System.out.println("Поток " + getName()
                    + " хочет извлечь число.");
            number = resource.getELement();
            while (number == null) {
                System.out.println("Поток " + getName()
                        + " ждет пока очередь заполнится.");
                resource.wait();
                System.out
                        .println("Поток " + getName() + " возобновил работу.");
                number = resource.getELement();
            }
            System.out
                    .println("Поток " + getName() + " извлек число " + number);
        }
    }

    private void setIntegersIntoResource() throws InterruptedException {
        Integer number = rand.nextInt(500);
        synchronized (resource) {
            resource.setElement(number);
            System.out.println("Поток " + getName() + " записал число "
                    + number);
            resource.notify();
        }
    }
}

