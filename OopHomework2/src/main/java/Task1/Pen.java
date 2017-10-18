package Task1;


import java.awt.*;
import java.util.Objects;

public class Pen {
    private Color color;
    private Integer price;

    private Pen() {
    }

    public Pen(Color color, Integer price) {
        this.color = color;
        this.price = price;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;
        if (o.getClass() != getClass()) return false;

        Pen pen = (Pen) o;
        if (!color.equals(pen.getColor())) return false;
        if (price != pen.getPrice()) return false;

        return true;
    }

    public int hashCode() {
        return Objects.hash(color,price);
    }

    public Color getColor() {
        return color;
    }

    public Integer getPrice() {
        return price;
    }


}
