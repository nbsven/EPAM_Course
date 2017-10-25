package Task2;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;


class ApplicationTest {

    @Test
    void showQuestionsAndAnswers(){
        Application application=new Application(Locale.US);
        System.out.println(application.getQuestions());
        System.out.println(application.getAnswers());

        application=new Application(new Locale("ru","RU"));
        System.out.println(application.getQuestions());
        System.out.println(application.getAnswers());

        application=new Application(Locale.getDefault());
        System.out.println(application.getQuestions());
        System.out.println(application.getAnswers());
    }

}