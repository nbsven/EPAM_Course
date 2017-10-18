package Task1;


import Task2.Stationary;
import org.apache.logging.log4j.message.StringFormattedMessage;

import java.awt.*;
import java.util.Objects;

public class Pen extends Stationary {
    private Color color;

    private Pen() {
    }

    public Pen(Color color, Integer price) {
        super(price);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (o.getClass() != getClass()) return false;

        Pen pen = (Pen) o;
        if (!color.equals(pen.getColor())) return false;
        if (!price.equals(pen.getPrice())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, price);
    }

    @Override
    public String toString() {
        StringFormattedMessage message =
                new StringFormattedMessage("Pen: color = %s; price = %d.", color, price);
        return message.getFormattedMessage();
    }

    public Color getColor() {
        return color;
    }


}
