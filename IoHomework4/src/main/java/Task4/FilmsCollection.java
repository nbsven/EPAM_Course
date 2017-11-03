package Task4;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class FilmsCollection implements Serializable {

    private ArrayList<Film> films = new ArrayList<>();

    public FilmsCollection(){

    }

    public FilmsCollection(ArrayList<Film> films) {
        this.films = films;
    }

    public ArrayList<Film> restoreFilmsCollection(String file) {
        try (ObjectInputStream stream = new ObjectInputStream(
                new FileInputStream("src/main/resources/Task4/" + file + ".txt"))) {
            films = (ArrayList<Film>) stream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return films;
    }

    public void saveFilmsCollection(String file) {
        try (ObjectOutputStream stream = new ObjectOutputStream(
                new FileOutputStream("src/main/resources/Task4/" + file + ".txt"))) {
            stream.writeObject(films);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Film> getFilms() {
        return films;
    }

    public void addFilm(Film film) {
        films.add(film);
    }

    @Override
    public String toString() {
        return "FilmsCollection{" +
                "films=" + films +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmsCollection that = (FilmsCollection) o;
        return Objects.equals(films, that.films);
    }

    @Override
    public int hashCode() {
        return Objects.hash(films);
    }
}
