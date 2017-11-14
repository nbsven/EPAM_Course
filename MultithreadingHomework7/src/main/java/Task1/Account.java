package Task1;

import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private static int count = 0;
    private int id;
    private volatile double value;
    private ReentrantLock lock=new ReentrantLock();

    public Account(double value) {
        this.id = count++;
        this.value = value;
    }

    public Account(int id, double value) {
        this.id = id;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public double getValue() {
        return value;
    }

    public synchronized void increaseValueSync(double value) {
        this.value += value;
    }

    public synchronized void reduceValueSync(double value) {
        this.value -= value;
    }

    public void increaseValue(double value) {
        lock.lock();
        this.value += value;
        lock.unlock();
    }

    public void reduceValue(double value) {
        lock.lock();
        this.value -= value;
        lock.unlock();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
