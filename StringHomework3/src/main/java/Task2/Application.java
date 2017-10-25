package Task2;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Application {

    private ResourceBundle questionsBundle;
    private ResourceBundle answersBunle;

    public Application(Locale locale){
        questionsBundle =ResourceBundle.getBundle("questions",locale);
        answersBunle = ResourceBundle.getBundle("answers", locale);
    }

    public String getQuestion(int key){
        return questionsBundle.getString(String.valueOf(key));
    }

    public String getAnswers(int key){
        return answersBunle.getString(String.valueOf(key));
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
        for(String key:answersBunle.keySet()){
            res.add(answersBunle.getString(key));
        }
        return res;
    }


}
