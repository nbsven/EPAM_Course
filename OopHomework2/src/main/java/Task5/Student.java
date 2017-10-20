package Task5;

import java.util.*;

public class Student {
    private static int counter = 0;
    private Integer studentId;
    private String name = "";
    private Set<Course> courses = new HashSet<>();


    public Student(String name) {
        this.studentId = counter++;
        this.name = name;
    }

    public Student(String name, Set<Course> courses) {
        this.studentId = counter++;
        this.name = name;
        this.courses = courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Map<String, ArrayList<Number>> getStudentMarks() {
        Map<String, ArrayList<Number>> result = new HashMap<>();
        for (Course course : courses) {
            result.put(course.getDiscipline().toString(), course.getStudentMarks(studentId));
        }
        return result;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Set<Course> getCourses() {
        return courses;
    }
}
