package Task2;

import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

class PropertiesReaderTest {

    @Test
    public void test() {
        Random rnd = new Random(42);

        for (int number = 0; number < 5; number++) {//create 5 properties files
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                    new File("src/main/resources/Task2/file" + number + ".properties")))) {
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

        Future[] mapFuture = new Future[5];
        for (int i = 0; i < 5; i++) {

            mapFuture[i] = PropertiesReader.readProperties(new File("src/main/resources/Task2/file" + i + ".properties"));
        }

        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(mapFuture[i].get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < 5; i++) {
            new File("src/main/resources/Task2/file" + i + ".properties").delete();
        }


    }
}