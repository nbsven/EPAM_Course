package Task2;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Application {

    private ResourceBundle questionsBundle;
    private ResourceBundle answersBundle;

    public Application(Locale locale){
        questionsBundle =ResourceBundle.getBundle("questions",locale);
        answersBundle = ResourceBundle.getBundle("answers", locale);
    }

    public String getQuestion(int key){
        return questionsBundle.getString(String.valueOf(key));
    }

    public String getAnswers(int key){
        return answersBundle.getString(String.valueOf(key));
    }

    public ArrayList<String> getQuestions(){
        ArrayList<String> res = new ArrayList<>();
        for(String key:questionsBundle.keySet()){
            res.add(questionsBundle.getString(key));
        }
        return res;
    }

    public ArrayList<String> getAnswers(){
        ArrayList<String> res = new ArrayList<>();
        for(String key: answersBundle.keySet()){
            res.add(answersBundle.getString(key));
        }
        return res;
    }


}
