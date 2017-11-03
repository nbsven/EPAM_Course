package Task3;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    void convert() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream("src/main/resources/Task3UTF_8.txt")))) {
            Converter.convert(reader);
        } catch (Exception e) {

        }
    }

}