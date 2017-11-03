package Task4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmsCollectionTest {
    @Test
    void saveRestoreFilmsTest() {
        FilmsCollection filmsCollection = new FilmsCollection();

        filmsCollection.addFilm(new Film("House").addActor("Tom").addActor("Anna"));
        filmsCollection.addFilm(new Film("House").addActor("Tom").addActor("Jack"));

        filmsCollection.saveFilmsCollection("firstCollection");
        System.out.println(filmsCollection);

        FilmsCollection filmsCollection1 = new FilmsCollection();
        filmsCollection1.restoreFilmsCollection("firstCollection");
    }
}