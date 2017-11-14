package Task1;

import checkers.units.quals.A;
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

    static boolean compareAccounts(ArrayList<Account> accountsOld, ArrayList<Account> accountsNew) {
        if (accountsNew.size() != accountsOld.size()) return false;
        for (int i = 0; i < accountsNew.size(); i++) {
            if (Math.round((accountsNew.get(i).getValue() - accountsOld.get(i).getValue()) * 100) != 0)
                return false;
        }
        return true;
    }

    @Test
    strictfp public void test() {
        ArrayList<Account> accounts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            accounts.add(new Account(i, 300));

        }

        File transactionsFile = new File("src/main/resources/Task1/transactions.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(transactionsFile))) {
            Random rnd = new Random();
            for (int i = 0; i < 1000; i++) {
                int from = rnd.nextInt(10);
                int to = rnd.nextInt(10);
                Double change = (rnd.nextDouble() * 10);
                String line = String.format("%s %s %s%n", from, to, change);
                accounts.get(from).reduceValue(change);
                accounts.get(to).increaseValue(change);
                writer.write(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(volume(accounts));
        System.out.println(accounts);

        ArrayList<Account> accountsNew = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            accountsNew.add(new Account(i, 300));

        }
        new TxHandler(accountsNew).parseTransactions(transactionsFile);
        System.out.println(volume(accountsNew));
        System.out.println(accountsNew);

        assertTrue(compareAccounts(accounts, accountsNew));
        transactionsFile.delete();

    }

}