package Task1;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    static double volume(ArrayList<Account> accounts) {
        double res = 0;
        for (Account account : accounts) {
            res += account.getValue();
        }
        return res;
    }

    @Test
    strictfp public void test() {
        final ArrayList<Account> accounts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            accounts.add(new Account(i, 300));

        }

        File transactionsFile = new File("src/main/resources/Task1/transactions.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(transactionsFile))) {
            Random rnd = new Random();
            for (int i = 0; i < 1000; i++) {
                int from = rnd.nextInt(10);
                int to = rnd.nextInt(10);
                Double change = (rnd.nextDouble() * 10)*100;
                change=change.longValue()/100.0;
                String line = String.format("%s %s %s%n", from, to, change);
                accounts.get(from).reduceValue(change);
                accounts.get(to).increaseValue(change);
                writer.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(accounts);

        ExecutorService executor = Executors.newFixedThreadPool(30);

        try (BufferedReader reader = new BufferedReader(new FileReader(transactionsFile))) {
            String line;
            int i=0;
            while ((line = reader.readLine()) != null) {
                System.out.println(i++);
                final String[] strings = line.split(" ");

                executor.execute(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        executor.shutdown();
        try {
            executor.awaitTermination(1,TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(accounts);

    }

}