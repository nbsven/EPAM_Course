package Task1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Words {
    private HashMap<String, Integer> keywordsCount = new HashMap<>();
    private ArrayList<String> keywordsList = new ArrayList<>();

    public HashMap<String, Integer> getKeywords(DataInputStream dataInputStream) {
        try (BufferedReader streamReader = new BufferedReader(new FileReader("src/main/resources/Keywords.txt"))) {
            String line;
            while ((line = streamReader.readLine()) != null) {
                keywordsList.addAll(Arrays.asList(line.split("\\s")));
            }
            System.out.println(keywordsList);
            dataInputStream.read();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
