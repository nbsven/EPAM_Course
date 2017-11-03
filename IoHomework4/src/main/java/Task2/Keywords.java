package Task2;

import Task1.Words;
import checkers.igj.quals.I;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Keywords {
    private static ArrayList<String> keywordsList = new ArrayList<>();

    static {
        initKeywordsList();
    }

    /**
     * Finds all keywords in .java file associated with dataInputStream
     * and count them.
     *
     * @param reader buffered reader of .java file
     * @return HashMap containing keywords with number of their using
     * @throws IOException
     */
    public static HashMap<String, Integer> getKeywords(BufferedReader reader) throws IOException {
        String line;
        HashMap<String, Integer> result = new HashMap<>();
        while ((line = reader.readLine()) != null) {
            for (String s : line.split("[\\s;]")) {
                int index = keywordsList.indexOf(s);
                if (index == -1) continue;
                if (result.containsKey(s)) {
                    result.put(s, result.get(s) + 1);
                } else {
                    result.put(s, 1);
                }
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
