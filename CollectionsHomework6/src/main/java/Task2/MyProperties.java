package Task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

;

public class MyProperties extends HashMap<String, String> {

    private MyProperties() {

    }

    public static MyProperties getNewProperties(String filePath) {
        MyProperties resultProperties = null;

        try (BufferedReader reader = new BufferedReader(new FileReader(new File(filePath)))) {
            String line;
            resultProperties = new MyProperties();
            while ((line = reader.readLine()) != null) {
                String key = line.split("=")[0];
                String value = line.substring(key.length() + 1);
                resultProperties.putIfAbsent(key, value);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found "+ e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return resultProperties;
    }

    @Override
    public String get(Object key) {
        return getProperty((String) key);
    }

    public String getProperty(String key) {
        try {
            return getString(key);
        } catch (KeyNotFoundException e) {
            System.out.printf("Key not found; key:%s%n",e.getMessage());
        }
        return null;
    }

    private String getString(String key) throws KeyNotFoundException {
        if (!this.containsKey(key))
            throw new KeyNotFoundException(key);
        return super.get(key);
    }
}
