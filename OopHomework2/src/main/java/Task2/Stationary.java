package Task2;

public abstract class Stationary {
    protected Integer price;

    protected Stationary(){
        price=0;
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
