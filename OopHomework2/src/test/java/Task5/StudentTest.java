package Task5;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class StudentTest {
    @Test
    void studentTest() {
        Course english = new Course(Discipline.ENGLISH);
        Student Oleg = new Student("Oleg");
        Student Anna = new Student("Anna");

        english.addStudent(Oleg);
        english.addStudent(Anna);

        english.addMarkForStudent(Oleg.getStudentId(), 3.1);
        english.addMarkForStudent(Oleg.getStudentId(), 4.2);
        english.addMarkForStudent(Anna.getStudentId(), 5);
        english.addMarkForStudent(Anna.getStudentId(), 4);
        english.addMarkForStudent(Anna.getStudentId(), 3);

        Course mathematics = new Course(Discipline.MATHEMATICS);
        mathematics.addStudent(Oleg);
        mathematics.addStudent(Anna);
        mathematics.addMarkForStudent(Oleg.getStudentId(), 5);
        mathematics.addMarkForStudent(Oleg.getStudentId(), 4);
        mathematics.addMarkForStudent(Anna.getStudentId(), 3);
        mathematics.addMarkForStudent(Anna.getStudentId(), 4);
        mathematics.addMarkForStudent(Anna.getStudentId(), 3);

        assertThat(english, not(mathematics));
        assertThat(english.getStudentMarks(Oleg.getStudentId()), not(english.getStudentMarks(Anna.getStudentId())));

        System.out.printf("Name: %s \nMarks: %s\n", Oleg.getName(), Oleg.getStudentMarks());
        System.out.printf("Name: %s \nMarks: %s\n", Anna.getName(), Anna.getStudentMarks());

    }
}
