package Task3;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;
import static org.junit.jupiter.api.Assertions.*;

class ScissorsTest {
    @Test
    void equals() {
        assertThat(new Scissors(100, Size.MEDIUM).equals(new Scissors(100, Size.MEDIUM)), is(true));
        assertThat(new Scissors(200, Size.MEDIUM).equals(new Scissors(100, Size.MEDIUM)), is(false));
        assertThat(new Scissors(200, Size.SMALL).equals(new Scissors(100, Size.MEDIUM)), is(false));


    }

}