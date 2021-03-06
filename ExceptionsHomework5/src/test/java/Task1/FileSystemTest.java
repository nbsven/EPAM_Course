package Task1;

import Task1.Exceptions.FileOrDirectoryNotExistsException;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {
    @Test
    void test() {
        Properties properties = new Properties();
        FileSystem system = new FileSystem();
        try {
            System.out.println(system.getDirs());
            system.changeDir("/");
            System.out.println(system.getDirs());
            system.changeDir("home");
            System.out.println(system.getDirs());
            system.changeDir("abra");
            System.out.println(system.getDirs());
            system.changeDir("Desktop");
            system.createTxtFile("text");
            system.addToTxtFile("text","new\ntext");
            system.deleteTxtFile("text");
            System.out.println("File:" + system.getFiles());
        } catch (FileOrDirectoryNotExistsException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}