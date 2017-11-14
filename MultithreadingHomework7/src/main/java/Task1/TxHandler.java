package Task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class TxHandler {

    private ArrayList<Account> accounts;


    public TxHandler(ArrayList<Account> accounts) {
        this.accounts = accounts;
    }


    private class Manager {
        private static final int THREADS = 4;
        private ArrayList<Account> accounts;

        private BlockingDeque<Task> tasks = new LinkedBlockingDeque<>(20);
        private BlockingDeque<Boolean> freeThreads = new LinkedBlockingDeque<>(THREADS);
        private ExecutorService executorService = Executors.newFixedThreadPool(THREADS);
        private ExecutorService singleThread = Executors.newSingleThreadExecutor();

        Manager(ArrayList<Account> accounts) {
            this.accounts = accounts;

            for(int i=0;i<THREADS;i++){
                freeThreads.offer(true);
            }
        }


        public void start() {
            while (!singleThread.isShutdown()) {
                singleThread.submit(tasks.poll());
            }
        }

        private class Task implements Runnable {
            String line;

            public Task(String line) {
                this.line = line;
            }

            @Override
            public void run() {

                String[] strings = line.split(" ");

                accounts.get(Integer.parseInt(strings[0])).reduceValue(Double.parseDouble(strings[2]));
                accounts.get(Integer.parseInt(strings[1])).increaseValue(Double.parseDouble(strings[2]));

                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                freeThreads.offer(true);
            }
        }

        public void offer(String line){
            tasks.offer(new Task(line));
        }

        public void stop(){
            singleThread.shutdown();
        }
    }


    public ArrayList<Account> parseTransactions(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            Manager manager = new Manager(accounts);
            while ((line = reader.readLine()) != null) {

                manager.offer(line);

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (Exception e) {
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
