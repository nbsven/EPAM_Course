package Task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Words {
    private static ArrayList<String> keywordsList = new ArrayList<>();

    static {
        initKeywordsList();
    }

    public static HashMap<String, Integer> getKeywords(DataInputStream dataInputStream) throws IOException {
        byte[] readBytes = dataInputStream.readAllBytes();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : readBytes) {
            stringBuilder.append((char) b);
        }

        HashMap<String, Integer> result = new HashMap<>();
        for (String s : stringBuilder.toString().split("\\s")) {
            int index = keywordsList.indexOf(s);
            if (index == -1) continue;
            if (result.containsKey(s)) {
                result.put(s, result.get(s) + 1);
            } else {
                result.put(s, 1);
            }
        }

        return result;
    }

    private static void initKeywordsList() {
        try (BufferedReader streamReader = new BufferedReader(new FileReader("src/main/resources/Keywords.txt"))) {
            String line;
            while ((line = streamReader.readLine()) != null) {
                keywordsList.addAll(Arrays.asList(line.split("\\s")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> getKeywordsList() {
        return new ArrayList<>(keywordsList);
    }
}
