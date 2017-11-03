package Task1;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class WordsTest {
    @Test
    void getKeywords() {
        try (DataInputStream stream = new DataInputStream(new FileInputStream(
                new File("src/main/resources/Course.java")))) {
            System.out.println(Words.getKeywordsList());
            System.out.printf("OopHomework2/src/main/java/Task5/Course.java : %s%n",Words.getKeywords(stream));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try(BufferedReader streamReader=new BufferedReader(new FileReader("src/main/resources/Keywords.txt"))){
            System.out.println(streamReader.readLine());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}