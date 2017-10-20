package Task4;

import Task1.Pen;
import Task2.Ruler;
import Task2.Workspace;
import Task3.Scissors;
import Task3.Size;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class SortedByPriceTest {
    @Test
    void compare() {
        Workspace workSpace = new Workspace("Nikolai");
        workSpace.addStationary(new Pen(137, Color.blue));
        workSpace.addStationary(new Ruler(100, 20));
        workSpace.addStationary(new Scissors(233, Size.MEDIUM));

        workSpace.sort(new SortedByPrice());
        System.out.println(workSpace.getStationers());
    }

}