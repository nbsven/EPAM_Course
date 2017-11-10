package Task2;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;

import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.*;

class MyPropertiesTest {
    @Test
    void test(){

        assertNull(MyProperties.getNewProperties("/src/main/resources/Task2/Test.properties"));
        assertNotNull(MyProperties.getNewProperties("src/main/resources/Task2/Test.properties"));

        MyProperties properties=MyProperties.getNewProperties("src/main/resources/Task2/Test.properties");
        assertNull(properties.get("languag"));
        assertThat(properties.get("language"),is("russian"));
        assertThat(properties.get("Str"),is("val"));


    }

}