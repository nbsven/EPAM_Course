package Task1;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.ResourceBundle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.*;

public class SerializeTest {

    @Test
    void ser(){
        ArrayList<Double> list =new ArrayList<>();
        list.add(0.0);
        list.add(1.5);
        list.add(-1002.1);
        try (ObjectOutputStream outputStream= new ObjectOutputStream(new FileOutputStream( new File("serTest.txt")))) {
            outputStream.writeObject(list);
        }catch (Exception e){
            e.getMessage();
        }

        ArrayList<Double> readedList=new ArrayList<>();
        try(ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream(new File("serTest.txt")))){
            readedList=(ArrayList<Double>) inputStream.readObject();
        }catch (Exception e){
            e.getMessage();
        }
        assertThat(readedList, is(list));

    }
}
