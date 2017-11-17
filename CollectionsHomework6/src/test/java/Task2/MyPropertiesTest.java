package Task2;

import Task2.MyProperties;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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