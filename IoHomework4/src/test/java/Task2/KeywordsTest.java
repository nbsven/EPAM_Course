package Task2;

import Task1.Words;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KeywordsTest {
    @Test
    void getKeywords() {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/Course.java"));
             DataInputStream stream = new DataInputStream(new FileInputStream(
                     new File("src/main/resources/Course.java")))
        ) {
            assertThat(Keywords.getKeywords(reader), Is.is(Words.getKeywords(stream)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}