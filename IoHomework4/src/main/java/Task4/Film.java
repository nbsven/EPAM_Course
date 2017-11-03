package Task4;

import java.io.Serializable;
import java.util.ArrayList;

public class Film implements Serializable {
    private String filmName="";
    private ArrayList<String> actors=new ArrayList<>();

    public Film(String filmName) {
        this.filmName = filmName;
    }

    public Film addActor(String name){
        actors.add(name);
        return this;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmName='" + filmName + '\'' +
                ", actors=" + actors +
                '}';
    }
}
