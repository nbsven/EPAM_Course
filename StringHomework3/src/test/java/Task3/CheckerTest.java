package Task3;

import org.junit.jupiter.api.Test;


import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {
    @Test
    void isLinksCorrect() {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(
                                new File("src/main/resources/Java.SE.03.Information handling_task_attachment.html")),
                        "cp1251")
        )) {
            Checker.isLinksCorrect(reader);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.printf("message : %s%n", e.getMessage());
        }

    }
}