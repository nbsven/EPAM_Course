package Task5;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {
    private static int counter = 0;
    private int courseId;
    private Discipline discipline;
    private HashMap<Integer, ArrayList<Number>> students = new HashMap<>();

    public Course(Discipline discipline) {
        this.courseId = counter++;
        this.discipline = discipline;
    }

    public void addStudent(Student student) {
        if (!students.containsKey(student.getStudentId())) {
            students.put(student.getStudentId(), new ArrayList<>());
            student.addCourse(this);
        }

    }

    public void addMarkForStudent(Integer studentId, Number number) {
        ArrayList<Number> students = this.students.get(studentId);
        switch (discipline) {
            case ENGLISH: {
                students.add(number.doubleValue());
                break;
            }
            case MATHEMATICS: {
                students.add(number.intValue());
                break;
            }
            case PROGRAMMING: {
                students.add(number.doubleValue());
                break;
            }
        }
    }

    public ArrayList<Number> getStudentMarks(Integer studentId) {
        return students.get(studentId);
    }

    public int getCourseId() {
        return courseId;
    }

    public Discipline getDiscipline() {
        return discipline;
    }
}
