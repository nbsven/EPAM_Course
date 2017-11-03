package Task4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(filmName, film.filmName) &&
                Objects.equals(actors, film.actors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmName, actors);
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmName='" + filmName + '\'' +
                ", actors=" + actors +
                '}';
    }
}
