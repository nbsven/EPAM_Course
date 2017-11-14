package Task2;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesReaderTest {

    @Test
    public void test() {
        File file1 = new File("src/main/resources/Task2/file1.properties");
        File file2 = new File("src/main/resources/Task2/file2.properties");
        Random rnd = new Random(42);
        for (int i = 0; i < 256; i++) {
            System.out.println(i + "=" + (char) i);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file1))) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 12; j++) {
                    line.append((char) (rnd.nextInt(26) + 97));
                }
                line.append("=");
                line.append(rnd.nextInt(Integer.MAX_VALUE));
                line.append("\n");
            }
            writer.write(line.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file2))) {
            StringBuilder line = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                for (int j = 0; j < 12; j++) {
                    line.append((char) (rnd.nextInt(26) + 97));
                }
                line.append("=");
                line.append(rnd.nextInt(Integer.MAX_VALUE));
                line.append("\n");
            }
            writer.write(line.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}