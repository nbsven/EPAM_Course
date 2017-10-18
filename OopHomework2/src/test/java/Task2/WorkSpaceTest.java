package Task2;

import Task1.Pen;
import Task3.Scissors;
import Task3.Size;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Comparator;

import static org.hamcrest.MatcherAssert.assertThat;

class WorkSpaceTest {
    @Test
    void calculateTotalPrice() {
        Workspace workSpace=new Workspace("Nikolai");
        workSpace.addStationary(new Pen(137,Color.blue));
        workSpace.addStationary(new Ruler(100,20));
        workSpace.addStationary(new Scissors(233, Size.MEDIUM));

        assertThat(workSpace.calculateTotalPrice(), Is.is(470));

    }

}