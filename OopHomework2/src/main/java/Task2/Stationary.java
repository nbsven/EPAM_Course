package Task2;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public abstract class Stationary {
    protected Integer price = 0;

    protected Stationary() {
        price = 0;
    }

    public Stationary(Integer price) {
        this.price = price;
    }

    public Integer getPrice() {
        return price;
    }

    @Override
    abstract public String toString();
}
