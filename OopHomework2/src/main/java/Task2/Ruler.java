package Task2;

import org.apache.logging.log4j.message.StringFormattedMessage;

import java.util.Objects;

public class Ruler extends Stationary {
    private Integer length;

    private Ruler() {

    }

    public Ruler(Integer price, Integer length) {
        super(price);
        this.length = length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null) return false;
        if (obj.getClass() != getClass()) return false;

        Ruler ruler = (Ruler) obj;
        if (!Objects.equals(length, ruler.getLength())) return false;
        if (!Objects.equals(price, ruler.getPrice())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, length);
    }

    @Override
    public String toString() {
        StringFormattedMessage message =
                new StringFormattedMessage("Ruler: length = %d; price = %d.", length, price);
        return message.getFormattedMessage();
    }

    public Integer getLength() {

        return length;
    }
}
