package Task2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PropertiesReader {
    private static class CallableTask implements Callable<Map<String, String>> {
        private File file;

        public CallableTask(File file) {
            this.file = file;
        }

        @Override
        public Map<String, String> call() throws Exception {
            HashMap<String, String> resultMap = new HashMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String key = line.split("=")[0];
                    String value = line.substring(key.length() + 1);
                    resultMap.putIfAbsent(key, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultMap;
        }
    }

    public static Future<Map<String, String>> readProperties(File file) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        return executorService.submit(new CallableTask(file));
    }
}
