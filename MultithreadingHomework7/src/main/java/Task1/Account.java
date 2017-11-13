package Task1;

public class Account {
    private static int count = 0;
    private int id;
    private volatile double value;

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

    public synchronized void increaseValueSync(double value){
        this.value+=value;
    }

    public synchronized void reduceValueSync(double value){
        this.value-=value;
    }

    public void increaseValue(double value){
        this.value+=value;
    }

    public void reduceValue(double value){
        this.value-=value;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", value=" + value +
                '}';
    }
}
