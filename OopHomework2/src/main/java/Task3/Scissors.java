package Task3;

import Task2.Stationary;

import java.util.Objects;

public class Scissors extends Stationary {
    private Size size;

    private Scissors() {
    }

    public Scissors(Integer price, Size size) {
        super(price);
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scissors scissors = (Scissors) o;

        if (!price.equals(scissors.price)) return false;
        if(!size.equals(size)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, price);
    }

    @Override
    public String toString() {
        return "Scissors{" +
                "size=" + size +
                ", price=" + price +
                '}';
    }
}
