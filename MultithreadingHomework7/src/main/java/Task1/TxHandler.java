package Task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.*;

public class TxHandler {

    private ArrayList<Account> accounts;
    private BlockingDeque<Integer> freeThreads = new LinkedBlockingDeque<>(4);
    private ExecutorService executorService = Executors.newFixedThreadPool(4);


    public TxHandler(ArrayList<Account> accounts) {
        this.accounts = accounts;
        for (int i = 0; i < freeThreads.remainingCapacity(); i++) {
            freeThreads.offer(1);
        }
    }

    private class Task implements Runnable {
        String line;
        ArrayList<Account> accounts;

        public Task(String line, ArrayList<Account> accounts) {
            this.line = line;
            this.accounts = accounts;
        }

        @Override
        public void run() {

            String[] strings = line.split(" ");

            accounts.get(Integer.parseInt(strings[0])).reduceValue(Double.parseDouble(strings[2]));
            accounts.get(Integer.parseInt(strings[1])).increaseValue(Double.parseDouble(strings[2]));

//            try {
//                Thread.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            freeThreads.offer(1);
        }
    }


    public ArrayList<Account> parseTransactions(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {

                freeThreads.poll();
                executorService.execute(new Task(line,accounts));

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }
}
