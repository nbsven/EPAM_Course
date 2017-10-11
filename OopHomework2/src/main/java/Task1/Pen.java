package Task1;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;


@Getter
@AllArgsConstructor
public class Pen {
    private Color color;
    private int price;

    private Pen() {
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
        final int PRIME = 59;
        int result = 1;
        final Object $color = this.getColor();
        result = result * PRIME + ($color == null ? 43 : $color.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Pen;
    }
}
