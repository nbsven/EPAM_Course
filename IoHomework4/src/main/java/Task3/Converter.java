package Task3;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Converter {
    public static StringBuilder convert(BufferedReader reader) throws Exception{
        StringBuilder result=new StringBuilder();

        try(BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("src/main/resources/Task3UTF_16.txt"), StandardCharsets.UTF_16))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
            }
        }

        return result;
    }
}
